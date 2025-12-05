package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import es.uned.tw.domain.model.ContentType;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ContentTypeEntity;
import lombok.NonNull;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * The interface Content type entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContentTypeEntityMapper {

    /**
     * To domain content type.
     *
     * @param contentType the content type
     * @return the content type
     */
    ContentType toDomain(@NonNull final ContentTypeEntity contentType);

    /**
     * To domain list.
     *
     * @param contentTypes the content types
     * @return the list
     */
    List<ContentType> toDomain(@NonNull final List<ContentTypeEntity> contentTypes);

    /**
     * From domain content type entity.
     *
     * @param contentType the content type
     * @return the content type entity
     */
    @InheritInverseConfiguration
    ContentTypeEntity fromDomain(@NonNull final ContentType contentType);
}
