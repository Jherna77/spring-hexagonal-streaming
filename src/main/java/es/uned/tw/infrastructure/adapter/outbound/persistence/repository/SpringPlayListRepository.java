package es.uned.tw.infrastructure.adapter.outbound.persistence.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.PlayListEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.UserContentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Spring play list repository.
 */
@Repository
public interface SpringPlayListRepository extends JpaRepository<PlayListEntity, UserContentPK> {
    /**
     * Find by user id ordered by date ascending list.
     *
     * @param userId the user id
     * @return the playlist list
     */
    List<PlayListEntity> findByUserIdOrderByDateAsc(final Long userId);

    /**
     * Find by user id and content id.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @return the playlist list
     */
    Optional<PlayListEntity> findByUserIdAndContentId(final Long userId, final Long contentId);
}