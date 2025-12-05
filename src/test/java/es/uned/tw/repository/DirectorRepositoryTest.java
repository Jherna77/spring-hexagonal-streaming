package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.DirectorEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringDirectorRepository;
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
 * The type Director repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DirectorRepositoryTest {
    @Autowired
    private SpringDirectorRepository directorRepository;

    /**
     * Test all directors.
     */
    @Test
    void testAllDirectors() {
        final List<DirectorEntity> directors = this.directorRepository.findAll();
        assertThat(directors).isNotNull();
        assertThat(directors).isNotEmpty();
        log.info("Directors: {}", directors);
    }

    /**
     * Test director with id 1.
     */
    @Test
    void testDirectorWithId1() {
        final Optional<DirectorEntity> director = this.directorRepository.findById(1L);
        assertThat(director.get()).isNotNull();
        assertThat(director.get().getName()).isNotNull();
        log.info("Director: {}", director.get());
    }
}
