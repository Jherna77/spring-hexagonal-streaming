package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import es.uned.tw.domain.model.Content;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ContentEntity;
import lombok.NonNull;
import org.mapstruct.*;

import java.util.List;

/**
 * The interface Content entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {ContentTypeEntityMapper.class, FeatureEntityMapper.class, GenreEntityMapper.class,
            DirectorEntityMapper.class, ActorEntityMapper.class})
public interface ContentEntityMapper {

    /**
     * To domain content.
     *
     * @param content the content
     * @return the content
     */
    Content toDomain(@NonNull final ContentEntity content);

    /**
     * To domain list.
     *
     * @param contents the contents
     * @return the list
     */
    List<Content> toDomain(@NonNull final List<ContentEntity> contents);

    /**
     * From domain content entity.
     *
     * @param content the content
     * @return the content entity
     */
    @InheritInverseConfiguration
    ContentEntity fromDomain(@NonNull final Content content);
    
}
