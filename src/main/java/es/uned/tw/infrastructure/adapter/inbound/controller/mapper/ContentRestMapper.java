package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.Content;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.ContentRequest;
import lombok.NonNull;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Content rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {ContentTypeRestMapper.class, FeatureRestMapper.class, GenreRestMapper.class,
                DirectorRestMapper.class, ActorRestMapper.class})
public interface ContentRestMapper {

    /**
     * To domain content.
     *
     * @param content the content
     * @return the content
     */
    Content toDomain(@NonNull final ContentRequest content);

    /**
     * To domain list.
     *
     * @param contents the contents
     * @return the list
     */
    List<Content> toDomain(@NonNull final List<ContentRequest> contents);

    /**
     * From domain content request.
     *
     * @param content the content
     * @return the content request
     */
    ContentRequest fromDomain(@NonNull final Content content);

    /**
     * From domain list.
     *
     * @param contents the contents
     * @return the list
     */
    List<ContentRequest> fromDomain(@NonNull final List<Content> contents);
}
