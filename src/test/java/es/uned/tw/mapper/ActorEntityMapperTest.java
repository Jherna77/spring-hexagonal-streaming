package es.uned.tw.mapper;

import es.uned.tw.domain.model.Actor;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ActorEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.ActorEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.ActorEntityMapperImpl;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringActorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Actor entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ActorEntityMapperTest {

    private final ActorEntityMapper actorMapper = new ActorEntityMapperImpl();
    @Autowired
    private SpringActorRepository actorRepository;

    /**
     * Test actor entity mapper.
     */
    @Test
    void testActorEntityMapper() {
        final Optional<ActorEntity> actorEntity = this.actorRepository.findById(1L);
        assertThat(actorEntity.get()).isNotNull();
        log.info("Actor entity: {}", actorEntity.get());

        final Actor actor = this.actorMapper.toDomain(actorEntity.get());
        assertThat(actor).isNotNull();
        assertThat(actor.getId()).isNotNull();
        assertThat(actor.getName()).isNotNull();
        assertThat(actor.getId()).isEqualTo(actorEntity.get().getId());
        assertThat(actor.getName()).isEqualTo(actorEntity.get().getName());
        log.info("Actor: {}", actor);
    }
}
