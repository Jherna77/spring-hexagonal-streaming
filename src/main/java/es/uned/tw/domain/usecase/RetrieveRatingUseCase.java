package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.RatingException;
import es.uned.tw.domain.model.Rating;

import java.util.List;
import java.util.Optional;

/**
 * The interface Retrieve rating use case.
 */
public interface RetrieveRatingUseCase {
    /**
     * Gets rating by content and user id.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @return the rating by content and user id
     * @throws RatingException the rating exception
     */
    Optional<Rating> getRatingByContentAndUserId(final Long userId, final Long contentId) throws RatingException;

    /**
     * Gets ratings.
     *
     * @return the ratings
     * @throws RatingException the rating exception
     */
    List<Rating> getRatings() throws RatingException;
}
