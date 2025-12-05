package es.uned.tw.infrastructure.adapter.outbound.persistence.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.UserEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Spring user repository.
 */
@Repository
public interface SpringUserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * Find user by email.
     *
     * @param email the email
     * @return the user entity
     */
    Optional<UserEntity> findByEmail(@NonNull final String email);

    /**
     * Find first user ordered by id descending.
     *
     * @return the user entity
     */
    Optional<UserEntity> findTopByOrderByIdDesc();
}
