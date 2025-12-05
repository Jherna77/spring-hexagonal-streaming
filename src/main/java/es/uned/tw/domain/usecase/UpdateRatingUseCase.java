package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.RatingException;
import es.uned.tw.domain.model.Rating;

/**
 * The interface Update rating use case.
 */
public interface UpdateRatingUseCase {
    /**
     * Update rating optional.
     *
     * @param rating the rating
     * @throws RatingException the rating exception
     */
    void updateRating(final Rating rating) throws RatingException;
}
