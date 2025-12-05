package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.HistoryException;
import es.uned.tw.domain.model.History;

import java.util.Optional;

/**
 * The interface Create history use case.
 */
public interface CreateHistoryUseCase {
    /**
     * Create history optional.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @return the content history played
     * @throws HistoryException the history exception
     */
    Optional<History> createHistory(final Long userId, final Long contentId) throws HistoryException;
}
