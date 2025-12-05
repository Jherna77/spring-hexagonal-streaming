package es.uned.tw.mapper;

import es.uned.tw.domain.model.Director;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.DirectorEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.DirectorEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.DirectorEntityMapperImpl;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringDirectorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Director entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DirectorEntityMapperTest {

    private final DirectorEntityMapper directorMapper = new DirectorEntityMapperImpl();
    @Autowired
    private SpringDirectorRepository directorRepository;

    /**
     * Test director entity mapper.
     */
    @Test
    void testDirectorEntityMapper() {
        final Optional<DirectorEntity> directorEntity = this.directorRepository.findById(1L);
        assertThat(directorEntity.get()).isNotNull();
        log.info("Director entity: {}", directorEntity.get());

        final Director director = this.directorMapper.toDomain(directorEntity.get());
        assertThat(director).isNotNull();
        assertThat(director.getId()).isNotNull();
        assertThat(director.getName()).isNotNull();
        assertThat(director.getId()).isEqualTo(directorEntity.get().getId());
        assertThat(director.getName()).isEqualTo(directorEntity.get().getName());
        log.info("Director: {}", director);
    }
}
