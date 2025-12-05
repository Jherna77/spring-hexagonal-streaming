package es.uned.tw.application.port;

import es.uned.tw.domain.model.History;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

/**
 * The interface History persistence port.
 * It defines all persisten operations to manage content history
 */
public interface HistoryPersistencePort {
    /**
     * Create history optional.
     *
     * @param history the history
     * @return the optional
     */
    Optional<History> createHistory(final History history);

    /**
     * Gets history by user id.
     *
     * @param userId     the user id
     * @param featureIds the feature ids
     * @return the history by user id
     */
    List<History> getHistoryByUserId(@NonNull final Long userId, @NonNull final List<Long> featureIds);

    /**
     * Count history by content id and user id long.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @return the long
     */
    Long countHistoryByContentIdAndUserId(final Long userId, final Long contentId);

    /**
     * Gets histories.
     *
     * @return the histories
     */
    List<History> getHistories();
}
