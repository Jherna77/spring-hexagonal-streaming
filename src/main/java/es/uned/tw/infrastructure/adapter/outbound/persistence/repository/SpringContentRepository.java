package es.uned.tw.infrastructure.adapter.outbound.persistence.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Spring content repository.
 */
@Repository
public interface SpringContentRepository extends JpaRepository<ContentEntity, Long> {
    /**
     * Find all ordered by added descending.
     *
     * @return the content list
     */
    List<ContentEntity> findAllByOrderByAddedDesc();

    /**
     * Find distinct contents in genres id or directors id or actors id ordered by added descending.
     *
     * @param genres    the genres
     * @param directors the directors
     * @param actors    the actors
     * @return the content list
     */
    List<ContentEntity> findDistinctByGenresIdInOrDirectorsIdInOrActorsIdInOrderByAddedDesc(
            final List<Long> genres, final List<Long> directors, final List<Long> actors);

    /**
     * Find by feature ids.
     *
     * @param featureIds the feature ids
     * @return the content list
     */
    List<ContentEntity> findByFeatureIdIn(final List<Long> featureIds);

    /**
     * Find by content ids and feature ids.
     *
     * @param ids        the ids
     * @param featureIds the feature ids
     * @return the content list
     */
    List<ContentEntity> findByIdInAndFeatureIdIn(final List<Long> ids, final List<Long> featureIds);

    /**
     * Find first content ordered by id descending.
     *
     * @return the content entity
     */
    Optional<ContentEntity> findTopByOrderByIdDesc();
}
