package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ContentTypeEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringContentTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Content type repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ContentTypeRepositoryTest {
    @Autowired
    private SpringContentTypeRepository contentTypeRepository;

    /**
     * Test all content types.
     */
    @Test
    void testAllContentTypes() {
        final List<ContentTypeEntity> contentTypes = this.contentTypeRepository.findAll();
        assertThat(contentTypes).isNotNull();
        assertThat(contentTypes).isNotEmpty();
        log.info("Types of content: {}", contentTypes);
    }

    /**
     * Test content type with id 1.
     */
    @Test
    void testContentTypeWithId1() {
        final Optional<ContentTypeEntity> contentType = this.contentTypeRepository.findById(1L);
        assertThat(contentType.get()).isNotNull();
        assertThat(contentType.get().getName()).isNotNull();
        log.info("Type of content: {}", contentType.get());
    }
}
