package es.uned.tw.infrastructure.adapter.outbound.persistence.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Spring director repository.
 */
@Repository
public interface SpringDirectorRepository extends JpaRepository<DirectorEntity, Long> {
}
