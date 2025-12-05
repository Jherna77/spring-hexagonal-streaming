package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.uned.tw.domain.model.History;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.HistoryEntity;
import lombok.NonNull;

/**
 * The interface History entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {UserEntityMapper.class, ContentEntityMapper.class})
public interface HistoryEntityMapper {
    /**
     * To domain history.
     *
     * @param history the history
     * @return the history
     */
    History toDomain(@NonNull final HistoryEntity history);

    /**
     * To domain list.
     *
     * @param history the history
     * @return the list
     */
    List<History> toDomain(@NonNull final List<HistoryEntity> history);

    /**
     * From domain history entity.
     *
     * @param history the history
     * @return the history entity
     */
    @InheritInverseConfiguration
    HistoryEntity fromDomain(@NonNull final History history);
}
