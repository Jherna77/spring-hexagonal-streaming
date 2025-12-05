package es.uned.tw.mapper;

import es.uned.tw.domain.model.Genre;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.GenreEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.GenreEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.GenreEntityMapperImpl;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringGenreRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Genre entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GenreEntityMapperTest {

    private final GenreEntityMapper genreMapper = new GenreEntityMapperImpl();
    @Autowired
    private SpringGenreRepository genreRepository;

    /**
     * Test genre entity mapper.
     */
    @Test
    void testGenreEntityMapper() {
        final Optional<GenreEntity> genreEntity = this.genreRepository.findById(1L);
        assertThat(genreEntity.get()).isNotNull();
        log.info("Genre entity: {}", genreEntity.get());

        final Genre genre = this.genreMapper.toDomain(genreEntity.get());
        assertThat(genre).isNotNull();
        assertThat(genre.getId()).isNotNull();
        assertThat(genre.getName()).isNotNull();
        assertThat(genre.getId()).isEqualTo(genreEntity.get().getId());
        assertThat(genre.getName()).isEqualTo(genreEntity.get().getName());
        log.info("Genre: {}", genre);
    }
}
