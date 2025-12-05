package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.ContentType;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.ContentTypeRequest;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Content type rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContentTypeRestMapper {

    /**
     * To domain content type.
     *
     * @param contentType the content type
     * @return the content type
     */
    ContentType toDomain(@NonNull final ContentTypeRequest contentType);

    /**
     * To domain list.
     *
     * @param contentTypes the content types
     * @return the list
     */
    List<ContentType> toDomain(@NonNull final List<ContentTypeRequest> contentTypes);

    /**
     * From domain content type request.
     *
     * @param contentType the content type
     * @return the content type request
     */
    ContentTypeRequest fromDomain(@NonNull final ContentType contentType);

    /**
     * From domain list.
     *
     * @param contentTypes the content types
     * @return the list
     */
    List<ContentTypeRequest> fromDomain(@NonNull final List<ContentType> contentTypes);
}
