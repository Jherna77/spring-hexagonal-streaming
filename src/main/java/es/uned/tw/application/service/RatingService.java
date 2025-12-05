package es.uned.tw.application.service;

import es.uned.tw.application.port.ContentPersistencePort;
import es.uned.tw.application.port.RatingPersistencePort;
import es.uned.tw.application.port.RatingServicePort;
import es.uned.tw.application.port.UserPersistencePort;
import es.uned.tw.domain.exception.RatingException;
import es.uned.tw.domain.model.Content;
import es.uned.tw.domain.model.Rating;
import es.uned.tw.domain.model.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * The class Rating service to manage rating logical operations in application domain.
 */
@RequiredArgsConstructor
public class RatingService implements RatingServicePort {
    private final RatingPersistencePort ratingPersistence;
    private final UserPersistencePort userPersistence;
    private final ContentPersistencePort contentPersistence;

    @Override
    public void createRating(@NonNull final Long userId, @NonNull final Long contentId,
                             @NonNull final Integer rate) throws RatingException {
        final Optional<User> user = this.userPersistence.getUserById(userId);
        final Optional<Content> content = this.contentPersistence.getContentById(contentId);
        final Rating rating = Rating.builder().
                user(user.get()).content(content.get()).
                rating(rate).date(LocalDateTime.now()).build();
        this.ratingPersistence.createRating(rating);
    }

    @Override
    public Optional<Rating> getRatingByContentAndUserId(@NonNull final Long userId,
                                                        @NonNull final Long contentId) throws RatingException {
        return this.ratingPersistence.getRatingByContentIdAndUserId(userId, contentId);
    }

    @Override
    public List<Rating> getRatings() throws RatingException {
        return this.ratingPersistence.getRatings();
    }

    @Override
    public void updateRating(Rating rating) throws RatingException {
        this.ratingPersistence.updateRating(rating);
    }

    @Override
    public void deleteRating(@NonNull final Rating rating) throws RatingException {
        this.ratingPersistence.deleteRating(rating);
    }
}
