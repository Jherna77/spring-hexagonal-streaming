package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.UserEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type User repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private SpringUserRepository userRepository;

    /**
     * Test all find by email.
     */
    @Test
    void testAllFindByEmail() {
        final Optional<UserEntity> user = this.userRepository.findByEmail("member@lsimax.es");
        assertThat(user.get()).isNotNull();
        assertThat(user.get().getId()).isNotNull();
        assertThat(user.get().getEmail()).isNotNull();
        assertThat(user.get().getPassword()).isNotNull();
        assertThat(user.get().getFirstName()).isNotNull();
        assertThat(user.get().getLastName()).isNotNull();
        assertThat(user.get().getPhone()).isNotNull();
        assertThat(user.get().getAddress()).isNotNull();
        assertThat(user.get().getCity()).isNotNull();
        assertThat(user.get().getPostalCode()).isNotNull();
        assertThat(user.get().getProvince()).isNotNull();
        assertThat(user.get().getCountry()).isNotNull();
        assertThat(user.get().getRole()).isNotNull();
        log.info("User: {}", user.get());

        assertThat(user.get().getFavGenres()).isNotNull();
        log.info("User genres: {}", user.get().getFavGenres());

        assertThat(user.get().getFavDirectors()).isNotNull();
        log.info("User directors: {}", user.get().getFavDirectors());

        assertThat(user.get().getFavActors()).isNotNull();
        log.info("User actors: {}", user.get().getFavActors());
    }
}
