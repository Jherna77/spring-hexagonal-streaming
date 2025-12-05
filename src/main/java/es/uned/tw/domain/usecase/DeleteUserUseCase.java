package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.UserException;

/**
 * The interface Delete user use case.
 */
public interface DeleteUserUseCase {
    /**
     * Delete user.
     *
     * @param id the id
     * @throws UserException the user exception
     */
    void deleteUser(final Long id) throws UserException;
}
