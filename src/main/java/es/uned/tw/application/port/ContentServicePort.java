package es.uned.tw.application.port;

import es.uned.tw.domain.usecase.DeleteContentUseCase;
import es.uned.tw.domain.usecase.RetrieveContentUseCase;
import es.uned.tw.domain.usecase.UpdateContentUseCase;

/**
 * The interface Content service port.
 * It extends to implements all use cases related with content operations
 */
public interface ContentServicePort extends RetrieveContentUseCase, UpdateContentUseCase,
        DeleteContentUseCase {
}
