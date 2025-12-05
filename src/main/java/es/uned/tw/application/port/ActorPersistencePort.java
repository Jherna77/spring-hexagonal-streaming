package es.uned.tw.application.port;

import es.uned.tw.domain.model.Actor;

import java.util.List;

/**
 * The interface Actor persistence port.
 * It extends to implements all use cases related with actor operations
 */
public interface ActorPersistencePort {
    /**
     * Gets actors.
     *
     * @return the actors
     */
    List<Actor> getActors();
}
