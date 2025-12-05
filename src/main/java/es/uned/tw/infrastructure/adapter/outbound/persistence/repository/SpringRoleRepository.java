package es.uned.tw.infrastructure.adapter.outbound.persistence.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Spring role repository.
 */
@Repository
public interface SpringRoleRepository extends JpaRepository<RoleEntity, Long> {
}
