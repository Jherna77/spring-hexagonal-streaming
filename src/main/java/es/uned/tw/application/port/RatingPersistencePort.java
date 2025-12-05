package es.uned.tw.application.port;

import es.uned.tw.domain.model.Rating;

import java.util.List;
import java.util.Optional;

/**
 * The interface Rating persistence port.
 * It defines all persisten operations to manage content ratings
 */
public interface RatingPersistencePort {
    /**
     * Create rating optional.
     *
     * @param rating the rating
     * @return the optional
     */
    Optional<Rating> createRating(final Rating rating);

    /**
     * Gets rating by user id.
     *
     * @param userId     the user id
     * @param featureIds the feature ids
     * @return the rating by user id
     */
    List<Rating> getRatingByUserId(final Long userId, final List<Long> featureIds);

    /**
     * Gets rating by content id and user id.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @return the rating by content id and user id
     */
    Optional<Rating> getRatingByContentIdAndUserId(final Long userId, final Long contentId);

    /**
     * Gets ratings.
     *
     * @return the ratings
     */
    List<Rating> getRatings();

    /**
     * Update rating optional.
     *
     * @param rating the rating
     * @return the optional
     */
    Optional<Rating> updateRating(final Rating rating);

    /**
     * Delete rating.
     *
     * @param rating the rating
     */
    void deleteRating(final Rating rating);
}
