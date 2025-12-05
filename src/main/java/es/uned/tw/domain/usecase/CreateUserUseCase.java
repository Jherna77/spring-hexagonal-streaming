package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.UserException;
import es.uned.tw.domain.model.User;

import java.util.Optional;

/**
 * The interface Create user use case.
 */
public interface CreateUserUseCase {
    /**
     * Create user optional.
     *
     * @param user the user
     * @return the user created
     * @throws UserException the user exception
     */
    Optional<User> createUser(final User user) throws UserException;
}
