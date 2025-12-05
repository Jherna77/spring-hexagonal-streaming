package es.uned.tw.infrastructure.adapter.outbound.persistence.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.RatingEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.UserContentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Spring rating repository.
 */
@Repository
public interface SpringRatingRepository extends JpaRepository<RatingEntity, UserContentPK> {
    /**
     * Find by user id and content id.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @return the rating entity
     */
    Optional<RatingEntity> findByUserIdAndContentId(final Long userId, final Long contentId);

    /**
     * Find list of distinct by user ordered by date descending.
     *
     * @param userId the user id
     * @return the ratings list
     */
    List<RatingEntity> findDistinctByUserIdOrderByDateDesc(final Long userId);
}
