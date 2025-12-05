package es.uned.tw.application.port;

import es.uned.tw.domain.usecase.CreateUserUseCase;
import es.uned.tw.domain.usecase.DeleteUserUseCase;
import es.uned.tw.domain.usecase.RetrieveUserUseCase;
import es.uned.tw.domain.usecase.UpdateUserUseCase;

/**
 * The interface User service port.
 * It extends to implements all use cases related with user operations
 */
public interface UserServicePort extends
        CreateUserUseCase, RetrieveUserUseCase, UpdateUserUseCase, DeleteUserUseCase {
}
