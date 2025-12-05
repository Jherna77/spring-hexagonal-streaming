package es.uned.tw.application.service;

import es.uned.tw.application.port.ActorPersistencePort;
import es.uned.tw.application.port.DirectorPersistencePort;
import es.uned.tw.application.port.GenrePersistencePort;
import es.uned.tw.application.port.PreferencesServicePort;
import es.uned.tw.domain.model.Actor;
import es.uned.tw.domain.model.Director;
import es.uned.tw.domain.model.Genre;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * The class Preferences service to manage user preference operations in application domain.
 * This service implements the 3 topics about preferences: genres, directors and actors
 */
@RequiredArgsConstructor
public class PreferencesService implements PreferencesServicePort {

    private final GenrePersistencePort genrePersistencePort;
    private final DirectorPersistencePort directorPersistencePort;
    private final ActorPersistencePort actorPersistencePort;

    @Override
    public List<Genre> getGenres() {
        return this.genrePersistencePort.getGenres();
    }

    @Override
    public List<Director> getDirectors() {
        return this.directorPersistencePort.getDirectors();
    }

    @Override
    public List<Actor> getActors() {
        return this.actorPersistencePort.getActors();
    }
}
