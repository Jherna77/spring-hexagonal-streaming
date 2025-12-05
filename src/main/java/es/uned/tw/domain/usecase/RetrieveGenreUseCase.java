package es.uned.tw.domain.usecase;

import es.uned.tw.domain.model.Genre;

import java.util.List;

/**
 * The interface Retrieve genre use case.
 */
public interface RetrieveGenreUseCase {
    /**
     * Gets genres.
     *
     * @return the genres
     */
    List<Genre> getGenres();
}
