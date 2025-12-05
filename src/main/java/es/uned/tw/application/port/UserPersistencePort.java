package es.uned.tw.application.port;

import es.uned.tw.domain.model.User;
import es.uned.tw.domain.model.UserRole;

import java.util.List;
import java.util.Optional;

/**
 * The interface User persistence port.
 * It defines all persisten operations to manage users
 */
public interface UserPersistencePort {
    /**
     * Gets roles.
     *
     * @return the roles
     */
    List<UserRole> getRoles();

    /**
     * Create user optional.
     *
     * @param user the user
     * @return the optional
     */
    Optional<User> createUser(final User user);

    /**
     * Gets users.
     *
     * @return the users
     */
    List<User> getUsers();

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    Optional<User> getUserById(final Long id);

    /**
     * Gets user by email.
     *
     * @param email the email
     * @return the user by email
     */
    Optional<User> getUserByEmail(final String email);

    /**
     * Update user optional.
     *
     * @param user the user
     * @return the optional
     */
    Optional<User> updateUser(final User user);

    /**
     * Delete user by id.
     *
     * @param id the id
     */
    void deleteUserById(final Long id);

    /**
     * Delete users.
     */
    void deleteUsers();
}
