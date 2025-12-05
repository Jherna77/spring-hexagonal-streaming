package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.RatingException;

/**
 * The interface Create rating use case.
 */
public interface CreateRatingUseCase {
    /**
     * Create rating optional.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @param rate      the rate
     * @throws RatingException the rating exception
     */
    void createRating(final Long userId, final Long contentId, final Integer rate) throws RatingException;
}
