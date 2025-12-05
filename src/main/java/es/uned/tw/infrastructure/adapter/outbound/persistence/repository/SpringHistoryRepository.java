package es.uned.tw.infrastructure.adapter.outbound.persistence.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Spring history repository.
 */
@Repository
public interface SpringHistoryRepository extends JpaRepository<HistoryEntity, Long> {
    /**
     * Find list of distinct history entries by user and ordered by date descending.
     *
     * @param userId the user id
     * @return the history list
     */
    List<HistoryEntity> findDistinctByUserIdOrderByDateDesc(final Long userId);

    /**
     * Count by user id and content id.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @return the number of occurrences
     */
    Long countByUserIdAndContentId(final Long userId, final Long contentId);

    /**
     * Find first history entry ordered by id descending.
     *
     * @return the history entity
     */
    Optional<HistoryEntity> findTopByOrderByIdDesc();
}