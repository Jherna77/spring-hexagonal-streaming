package es.uned.tw.domain.usecase;

import es.uned.tw.domain.model.Actor;

import java.util.List;

/**
 * The interface Retrieve actor use case.
 */
public interface RetrieveActorUseCase {
    /**
     * Gets actors.
     *
     * @return the actors
     */
    List<Actor> getActors();
}
