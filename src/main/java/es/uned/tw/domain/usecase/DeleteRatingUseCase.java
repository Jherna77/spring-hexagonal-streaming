package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.RatingException;
import es.uned.tw.domain.model.Rating;

/**
 * The interface Delete rating use case.
 */
public interface DeleteRatingUseCase {
    /**
     * Delete rating.
     *
     * @param rating the rating
     * @throws RatingException the rating exception
     */
    void deleteRating(final Rating rating) throws RatingException;
}
