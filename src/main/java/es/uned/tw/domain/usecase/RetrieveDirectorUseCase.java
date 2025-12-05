package es.uned.tw.domain.usecase;

import es.uned.tw.domain.model.Director;

import java.util.List;

/**
 * The interface Retrieve director use case.
 */
public interface RetrieveDirectorUseCase {
    /**
     * Gets directors.
     *
     * @return the directors
     */
    List<Director> getDirectors();
}
