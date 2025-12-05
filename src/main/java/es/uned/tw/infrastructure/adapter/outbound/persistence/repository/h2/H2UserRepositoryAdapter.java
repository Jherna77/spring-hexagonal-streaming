package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.UserPersistencePort;
import es.uned.tw.domain.model.User;
import es.uned.tw.domain.model.UserRole;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.UserEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.RoleEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.UserEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringRoleRepository;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringUserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The class with specific H2 provided implementation as user repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2UserRepositoryAdapter implements UserPersistencePort {
    private final SpringRoleRepository roleRepository;
    private final RoleEntityMapper roleMapper;

    private final SpringUserRepository userRepository;
    private final UserEntityMapper userMapper;

    @Override
    public List<UserRole> getRoles() {
        return this.roleMapper.toDomain(this.roleRepository.findAll());
    }

    @Override
    public Optional<User> createUser(@NonNull final User user) {
        UserEntity entity = this.userMapper.fromDomain(user);
        if (Objects.isNull(entity.getId())) {
            entity.setId(this.userRepository.findTopByOrderByIdDesc().map(e -> e.getId() + 1L).orElse(0L));
        }

        log.info("Creating {}", entity);
        return Optional.ofNullable(this.userMapper.toDomain(this.userRepository.save(entity)));
    }

    @Override
    public List<User> getUsers() {
        log.info("Listing all users");
        return this.userRepository.findAll().stream().
                map(this.userMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUserById(@NonNull final Long id) {
        log.info("Getting User(id={})", id);
        return this.userRepository.findById(id).map(this.userMapper::toDomain);
    }

    @Override
    public Optional<User> getUserByEmail(@NonNull final String email) {
        log.info("Getting User(email={})", email);
        return this.userRepository.findByEmail(email).map(this.userMapper::toDomain);
    }

    @Override
    public Optional<User> updateUser(@NonNull final User user) {
        final UserEntity entity = this.userMapper.fromDomain(user);
        log.info("Updating {}", entity);
        return Optional.ofNullable(this.userMapper.toDomain(this.userRepository.save(entity)));
    }

    @Override
    public void deleteUserById(@NonNull final Long id) {
        log.info("Deleting User(id={})", id);
        this.userRepository.deleteById(id);
    }

    @Override
    public void deleteUsers() {
        log.info("Deleting all users");
        this.userRepository.deleteAll();
    }
}
