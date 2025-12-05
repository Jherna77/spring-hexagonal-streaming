package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ContentEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringContentRepository;
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
 * The type Content repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ContentRepositoryTest {

    @Autowired
    private SpringContentRepository contentRepository;

    /**
     * Test all contents.
     */
    @Test
    void testAllContents() {
        final List<ContentEntity> contents = this.contentRepository.findAll();
        assertThat(contents).isNotNull();
        assertThat(contents).isNotEmpty();
        log.info("Contents: {}", contents);
    }

    /**
     * Test content with id 1.
     */
    @Test
    void testContentWithId1() {
        final Optional<ContentEntity> content = this.contentRepository.findById(1L);
        assertThat(content.get()).isNotNull();
        assertThat(content.get().getAdded()).isNotNull();
        assertThat(content.get().getFeature()).isNotNull();
        assertThat(content.get().getType()).isNotNull();
        assertThat(content.get().getTitle()).isNotNull();
        assertThat(content.get().getSynopsis()).isNotNull();
        assertThat(content.get().getProduction()).isNotNull();
        assertThat(content.get().getPremier()).isNotNull();
        assertThat(content.get().getCover()).isNotNull();
        assertThat(content.get().getResourcePath()).isNotNull();
        log.info("Content: {}", content.get());

        assertThat(content.get().getGenres()).isNotNull();
        log.info("Content genres: {}", content.get().getGenres());

        assertThat(content.get().getDirectors()).isNotNull();
        log.info("Content directors: {}", content.get().getDirectors());

        assertThat(content.get().getActors()).isNotNull();
        log.info("Content actors: {}", content.get().getActors());
    }
}