package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.RatingPersistencePort;
import es.uned.tw.domain.model.Rating;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.RatingEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.RatingEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringRatingRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The class specific H2 provided implementation as rating repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2RatingRepositoryAdapter implements RatingPersistencePort {

    private final SpringRatingRepository ratingRepository;
    private final RatingEntityMapper ratingMapper;


    @Override
    public Optional<Rating> createRating(@NonNull final Rating rating) {
        final RatingEntity entity = this.ratingMapper.fromDomain(rating);
        log.info("Creating {}", entity);
        return Optional.ofNullable(this.ratingMapper.toDomain(this.ratingRepository.save(entity)));
    }

    @Override
    public List<Rating> getRatingByUserId(@NonNull final Long userId, @NonNull final List<Long> featureIds) {
        log.info("Getting rating by User(id={})", userId);
        return this.ratingMapper.toDomain(this.ratingRepository.findDistinctByUserIdOrderByDateDesc(userId)).
                stream().filter(r -> featureIds.contains(r.getContent().getFeature().getId())).
                collect(Collectors.toList());
    }

    @Override
    public Optional<Rating> getRatingByContentIdAndUserId(@NonNull final Long userId, @NonNull final Long contentId) {
        log.info("Getting rating by User(id={}) Content(id={})", userId, contentId);
        return this.ratingRepository.findByUserIdAndContentId(userId, contentId).
                map(this.ratingMapper::toDomain);
    }

    @Override
    public List<Rating> getRatings() {
        log.info("Listing all ratings");
        return this.ratingRepository.findAll().stream().
                map(this.ratingMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Rating> updateRating(@NonNull final Rating rating) {
        return Optional.ofNullable(this.ratingMapper.toDomain(
                this.ratingRepository.save(this.ratingMapper.fromDomain(rating))));
    }

    @Override
    public void deleteRating(@NonNull final Rating rating) {
        log.info("Deleting rating {}", rating);
        this.ratingRepository.delete(this.ratingMapper.fromDomain(rating));

    }

}