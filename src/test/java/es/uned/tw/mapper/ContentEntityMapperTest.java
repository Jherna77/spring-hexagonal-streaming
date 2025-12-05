package es.uned.tw.mapper;

import es.uned.tw.domain.model.Content;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ContentEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.*;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Content entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ContentEntityMapperTest {

    private final ContentEntityMapper contentMapper = new ContentEntityMapperImpl(
            new ContentTypeEntityMapperImpl(), new FeatureEntityMapperImpl(), new GenreEntityMapperImpl(),
            new DirectorEntityMapperImpl(), new ActorEntityMapperImpl());
    @Autowired
    private SpringContentRepository contentRepository;

    /**
     * Test content entity mapper.
     */
    @Test
    void testContentEntityMapper() {
        final Optional<ContentEntity> contentEntity = this.contentRepository.findById(1L);
        assertThat(contentEntity.get()).isNotNull();
        log.info("Content entity: {}", contentEntity.get());
        log.info("Content entity genres: {}", contentEntity.get().getGenres());
        log.info("Content entity directors: {}", contentEntity.get().getDirectors());
        log.info("Content entity actors: {}", contentEntity.get().getActors());

        final Content content = this.contentMapper.toDomain(contentEntity.get());
        assertThat(content).isNotNull();
        assertThat(content.getId()).isNotNull();
        assertThat(content.getAdded()).isNotNull();
        assertThat(content.getFeature()).isNotNull();
        assertThat(content.getType()).isNotNull();
        assertThat(content.getTitle()).isNotNull();
        assertThat(content.getSynopsis()).isNotNull();
        assertThat(content.getProduction()).isNotNull();
        assertThat(content.getPremier()).isNotNull();
        assertThat(content.getCover()).isNotNull();
        assertThat(content.getResourcePath()).isNotNull();
        assertThat(content.getId()).isEqualTo(contentEntity.get().getId());
        assertThat(content.getAdded()).isEqualTo(contentEntity.get().getAdded());
        assertThat(content.getFeature().getId()).isEqualTo(contentEntity.get().getFeature().getId());
        assertThat(content.getType().getId()).isEqualTo(contentEntity.get().getType().getId());
        assertThat(content.getTitle()).isEqualTo(contentEntity.get().getTitle());
        assertThat(content.getSynopsis()).isEqualTo(contentEntity.get().getSynopsis());
        assertThat(content.getProduction()).isEqualTo(contentEntity.get().getProduction());
        assertThat(content.getPremier()).isEqualTo(contentEntity.get().getPremier());
        assertThat(content.getCover()).isEqualTo(contentEntity.get().getCover());
        assertThat(content.getResourcePath()).isEqualTo(contentEntity.get().getResourcePath());
        log.info("Content: {}", content);

        assertThat(content.getGenres()).isNotNull();
        assertThat(content.getGenres()).isNotEmpty();
        assertThat(content.getGenres().size()).isEqualTo(contentEntity.get().getGenres().size());
        log.info("Content genres: {}", content.getGenres());

        assertThat(content.getDirectors()).isNotNull();
        assertThat(content.getDirectors()).isNotEmpty();
        assertThat(content.getDirectors().size()).isEqualTo(contentEntity.get().getDirectors().size());
        log.info("Content directors: {}", content.getDirectors());

        assertThat(content.getActors()).isNotNull();
        assertThat(content.getDirectors()).isNotEmpty();
        assertThat(content.getActors().size()).isEqualTo(contentEntity.get().getActors().size());
        log.info("Content actors: {}", content.getActors());
    }
}
