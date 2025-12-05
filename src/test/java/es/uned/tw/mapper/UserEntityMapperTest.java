package es.uned.tw.mapper;

import es.uned.tw.domain.model.User;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.UserEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.*;
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
 * The type User entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserEntityMapperTest {

    private final UserEntityMapper userMapper = new UserEntityMapperImpl(
            new RoleEntityMapperImpl(), new GenreEntityMapperImpl(),
            new DirectorEntityMapperImpl(), new ActorEntityMapperImpl());
    @Autowired
    private SpringUserRepository userRepository;

    /**
     * Test user entity mapper.
     */
    @Test
    void testUserEntityMapper() {
        final Optional<UserEntity> userEntity = this.userRepository.findByEmail("member@lsimax.es");
        assertThat(userEntity.get()).isNotNull();
        log.info("User entity: {}", userEntity.get());
        log.info("User entity genres: {}", userEntity.get().getFavGenres());
        log.info("User entity directors: {}", userEntity.get().getFavDirectors());
        log.info("User entity actors: {}", userEntity.get().getFavActors());

        final User user = this.userMapper.toDomain(userEntity.get());
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
        assertThat(user.getEmail()).isNotNull();
        assertThat(user.getPassword()).isNotNull();
        assertThat(user.getFirstName()).isNotNull();
        assertThat(user.getLastName()).isNotNull();
        assertThat(user.getPhone()).isNotNull();
        assertThat(user.getAddress()).isNotNull();
        assertThat(user.getCity()).isNotNull();
        assertThat(user.getPostalCode()).isNotNull();
        assertThat(user.getProvince()).isNotNull();
        assertThat(user.getCountry()).isNotNull();
        assertThat(user.getRole().getName()).isNotNull();
        assertThat(user.getId()).isEqualTo(userEntity.get().getId());
        assertThat(user.getEmail()).isEqualTo(userEntity.get().getEmail());
        assertThat(user.getPassword()).isEqualTo(userEntity.get().getPassword());
        assertThat(user.getFirstName()).isEqualTo(userEntity.get().getFirstName());
        assertThat(user.getLastName()).isEqualTo(userEntity.get().getLastName());
        assertThat(user.getPhone()).isEqualTo(userEntity.get().getPhone());
        assertThat(user.getAddress()).isEqualTo(userEntity.get().getAddress());
        assertThat(user.getCity()).isEqualTo(userEntity.get().getCity());
        assertThat(user.getPostalCode()).isEqualTo(userEntity.get().getPostalCode());
        assertThat(user.getProvince()).isEqualTo(userEntity.get().getProvince());
        assertThat(user.getCountry()).isEqualTo(userEntity.get().getCountry());
        assertThat(user.getRole().getName()).isEqualTo(userEntity.get().getRole().getName());
        log.info("User: {}", user);

        assertThat(user.getGenres()).isNotNull();
        assertThat(user.getGenres().size()).isEqualTo(userEntity.get().getFavGenres().size());
        log.info("User genres: {}", user.getGenres());

        assertThat(user.getDirectors()).isNotNull();
        assertThat(user.getDirectors().size()).isEqualTo(userEntity.get().getFavDirectors().size());
        log.info("User directors: {}", user.getDirectors());

        assertThat(user.getActors()).isNotNull();
        assertThat(user.getActors().size()).isEqualTo(userEntity.get().getFavActors().size());
        log.info("User actors: {}", user.getActors());
    }
}
