package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.UserException;
import es.uned.tw.domain.model.User;
import es.uned.tw.domain.model.UserRole;

import java.util.List;
import java.util.Optional;

/**
 * The interface Retrieve user use case.
 */
public interface RetrieveUserUseCase {
    /**
     * Gets user roles.
     *
     * @return the user roles
     * @throws UserException the user exception
     */
    List<UserRole> getRoles() throws UserException;

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     * @throws UserException the user exception
     */
    Optional<User> getUserById(final Long id) throws UserException;

    /**
     * Gets user by email.
     *
     * @param email the email
     * @return the user by email
     * @throws UserException the user exception
     */
    Optional<User> getUserByEmail(final String email) throws UserException;

    /**
     * Gets users.
     *
     * @return the users
     */
    List<User> getUsers();
}
