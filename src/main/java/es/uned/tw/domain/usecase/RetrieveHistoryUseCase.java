package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.HistoryException;
import es.uned.tw.domain.model.History;

import java.util.List;

/**
 * The interface Retrieve history use case.
 */
public interface RetrieveHistoryUseCase {
    /**
     * Gets history count by user id and content id.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @return the history count by user id and content id
     * @throws HistoryException the history exception
     */
    Long getHistoryCountByUserIdAndContentId(final Long userId, final Long contentId) throws HistoryException;

    /**
     * Gets history.
     *
     * @return the history
     * @throws HistoryException the history exception
     */
    List<History> getHistory() throws HistoryException;
}
