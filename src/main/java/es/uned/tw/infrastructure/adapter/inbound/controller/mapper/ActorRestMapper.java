package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.Actor;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.ActorRequest;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Actor rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActorRestMapper {

    /**
     * To domain actor.
     *
     * @param actor the actor
     * @return the actor
     */
    Actor toDomain(@NonNull final ActorRequest actor);

    /**
     * From domain actor request.
     *
     * @param actor the actor
     * @return the actor request
     */
    ActorRequest fromDomain(@NonNull final Actor actor);

    /**
     * From domain list.
     *
     * @param actors the actors
     * @return the list
     */
    List<ActorRequest> fromDomain(@NonNull final List<Actor> actors);
}
