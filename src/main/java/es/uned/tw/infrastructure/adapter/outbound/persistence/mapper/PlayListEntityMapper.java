package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.uned.tw.domain.model.PlayList;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.PlayListEntity;
import lombok.NonNull;

/**
 * The interface Play list entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {UserEntityMapper.class, ContentEntityMapper.class})
public interface PlayListEntityMapper {

    /**
     * To domain play list.
     *
     * @param playList the play list
     * @return the play list
     */
    PlayList toDomain(@NonNull final PlayListEntity playList);

    /**
     * To domain list.
     *
     * @param playList the play list
     * @return the list
     */
    List<PlayList> toDomain(@NonNull final List<PlayListEntity> playList);

    /**
     * From domain play list entity.
     *
     * @param playList the play list
     * @return the play list entity
     */
    @InheritInverseConfiguration
    PlayListEntity fromDomain(@NonNull final PlayList playList);
}