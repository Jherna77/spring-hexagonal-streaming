package es.uned.tw.infrastructure.adapter.outbound.persistence.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.SubscriptionEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Spring subscription repository.
 */
@Repository
public interface SpringSubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
    /**
     * Find by user id.
     *
     * @param id the id
     * @return the subscription entity
     */
    Optional<SubscriptionEntity> findByUserId(@NonNull final Long id);

    /**
     * Find first subscription ordered by id descending
     *
     * @return the subscription entity
     */
    Optional<SubscriptionEntity> findTopByOrderByIdDesc();
}
