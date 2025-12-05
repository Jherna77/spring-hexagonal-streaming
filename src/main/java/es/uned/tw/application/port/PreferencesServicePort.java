package es.uned.tw.application.port;

import es.uned.tw.domain.usecase.RetrieveActorUseCase;
import es.uned.tw.domain.usecase.RetrieveDirectorUseCase;
import es.uned.tw.domain.usecase.RetrieveGenreUseCase;

/**
 * The interface Preferences service port.
 * It extends to implements all use cases related with user preference operations,
 * grouping all about Genres, Directors and Actors
 */
public interface PreferencesServicePort extends
        RetrieveGenreUseCase, RetrieveDirectorUseCase, RetrieveActorUseCase {
}
