package es.uned.tw.application.port;

import es.uned.tw.domain.model.Genre;

import java.util.List;

/**
 * The interface Genre persistence port.
 * It defines all persisten operations to manage genres
 */
public interface GenrePersistencePort {
    /**
     * Gets genres.
     *
     * @return the genres
     */
    List<Genre> getGenres();
}
