package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.ActorEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringActorRepository;
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
 * The type Actor repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ActorRepositoryTest {
    @Autowired
    private SpringActorRepository actorRepository;

    /**
     * Test all actors.
     */
    @Test
    void testAllActors() {
        final List<ActorEntity> actors = this.actorRepository.findAll();
        assertThat(actors).isNotNull();
        assertThat(actors).isNotEmpty();
        log.info("Actors: {}", actors);
    }

    /**
     * Test actor with id 1.
     */
    @Test
    void testActorWithId1() {
        final Optional<ActorEntity> actor = this.actorRepository.findById(1L);
        assertThat(actor.get()).isNotNull();
        assertThat(actor.get().getName()).isNotNull();
        log.info("Actor: {}", actor.get());
    }
}
