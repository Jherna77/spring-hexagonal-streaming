package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.GenreEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringGenreRepository;
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
 * The type Genre repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GenreRepositoryTest {
    @Autowired
    private SpringGenreRepository genreRepository;

    /**
     * Test all genres.
     */
    @Test
    void testAllGenres() {
        final List<GenreEntity> genres = this.genreRepository.findAll();
        assertThat(genres).isNotNull();
        assertThat(genres).isNotEmpty();
        log.info("Genres: {}", genres);
    }

    /**
     * Test genre with id 1.
     */
    @Test
    void testGenreWithId1() {
        final Optional<GenreEntity> genre = this.genreRepository.findById(1L);
        assertThat(genre.get()).isNotNull();
        assertThat(genre.get().getName()).isNotNull();
        log.info("Genre: {}", genre.get());
    }
}
