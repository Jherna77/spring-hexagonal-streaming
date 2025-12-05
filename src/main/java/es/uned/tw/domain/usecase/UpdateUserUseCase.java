package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.UserException;
import es.uned.tw.domain.model.User;

import java.util.Optional;

/**
 * The interface Update user use case.
 */
public interface UpdateUserUseCase {
    /**
     * Update user optional.
     *
     * @param user the user
     * @return the User updated
     * @throws UserException the user exception
     */
    Optional<User> updateUser(final User user) throws UserException;
}
