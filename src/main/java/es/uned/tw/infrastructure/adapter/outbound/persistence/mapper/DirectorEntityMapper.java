package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import es.uned.tw.domain.model.Director;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.DirectorEntity;
import lombok.NonNull;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Director entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DirectorEntityMapper {

    /**
     * To domain director.
     *
     * @param director the director
     * @return the director
     */
    Director toDomain(@NonNull final DirectorEntity director);

    /**
     * To domain list.
     *
     * @param directors the directors
     * @return the list
     */
    List<Director> toDomain(@NonNull final List<DirectorEntity> directors);

    /**
     * From domain director entity.
     *
     * @param director the director
     * @return the director entity
     */
    @InheritInverseConfiguration
    DirectorEntity fromDomain(@NonNull final Director director);
}
