package es.uned.tw.application.service;

import es.uned.tw.application.port.UserPersistencePort;
import es.uned.tw.application.port.UserServicePort;
import es.uned.tw.domain.exception.UserNotFoundException;
import es.uned.tw.domain.model.User;
import es.uned.tw.domain.model.UserRole;
import es.uned.tw.domain.type.UserRoleType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

/**
 * The class User service to manage user operations in application domain.
 */
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserServicePort {

    private final UserPersistencePort userPersistence;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Optional<User> createUser(@NonNull final User user) {
        log.info("Creating user {}", user);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.builder().id((long) UserRoleType.MEMBER.ordinal()).
                name(UserRoleType.MEMBER.name()).build());
        log.info("Persisting user {}", user);
        final Optional<User> createdUser = this.userPersistence.createUser(user);
        if (createdUser.isPresent()) {
            final Optional<User> newUser = this.userPersistence.getUserById(createdUser.get().getId());
            if (newUser.isPresent()) {
                newUser.get().setGenres(user.getGenres());
                newUser.get().setDirectors(user.getDirectors());
                newUser.get().setActors(user.getActors());
                this.userPersistence.updateUser(newUser.get());
                log.info("Created new {}", newUser);
            } else {
                log.error("Error creating user because not exist after persist {}", user);
            }
        }
        return createdUser;
    }

    @Override
    public Optional<User> updateUser(@NonNull final User user) {
        if (Optional.ofNullable(user.getId()).isEmpty()) {
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            return this.userPersistence.createUser(user);
        }
        final String pass = this.passwordEncoder.encode(user.getPassword());
        final Optional<User> old = this.userPersistence.getUserById(user.getId());
        if (old.isPresent() && !old.get().getPassword().equals(pass)) {
            user.setPassword(pass);
        }
        return this.userPersistence.updateUser(user);
    }

    @Override
    @SneakyThrows
    public void deleteUser(@NonNull final Long id) {
        this.userPersistence.deleteUserById(this.getUserById(id).
                orElseThrow(UserNotFoundException::new).getId());
    }

    @Override
    public List<UserRole> getRoles() {
        return this.userPersistence.getRoles();
    }

    @Override
    public Optional<User> getUserById(@NonNull final Long id) {
        return this.userPersistence.getUserById(id);
    }

    @Override
    public Optional<User> getUserByEmail(@NonNull final String email) {
        return this.userPersistence.getUserByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return this.userPersistence.getUsers();
    }
}
