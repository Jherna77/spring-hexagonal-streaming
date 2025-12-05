package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import es.uned.tw.domain.model.Actor;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ActorEntity;
import lombok.NonNull;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Actor entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActorEntityMapper {

    /**
     * To domain actor.
     *
     * @param actor the actor
     * @return the actor
     */
    Actor toDomain(@NonNull final ActorEntity actor);

    /**
     * To domain list.
     *
     * @param actors the actors
     * @return the list
     */
    List<Actor> toDomain(@NonNull final List<ActorEntity> actors);

    /**
     * From domain actor entity.
     *
     * @param actor the actor
     * @return the actor entity
     */
    @InheritInverseConfiguration
    ActorEntity fromDomain(@NonNull final Actor actor);
}
