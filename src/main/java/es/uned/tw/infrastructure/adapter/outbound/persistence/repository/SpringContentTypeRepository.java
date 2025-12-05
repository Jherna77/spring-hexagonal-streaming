package es.uned.tw.infrastructure.adapter.outbound.persistence.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ContentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Spring content type repository.
 */
@Repository
public interface SpringContentTypeRepository extends JpaRepository<ContentTypeEntity, Long> {
}
