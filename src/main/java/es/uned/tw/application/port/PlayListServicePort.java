package es.uned.tw.application.port;

import es.uned.tw.domain.usecase.CreatePlayListUseCase;
import es.uned.tw.domain.usecase.DeletePlayListUseCase;
import es.uned.tw.domain.usecase.RetrievePlayListUseCase;

/**
 * The interface Play list service port.
 * It extends to implements all use cases related with content play list operations
 */
public interface PlayListServicePort extends CreatePlayListUseCase,
        RetrievePlayListUseCase, DeletePlayListUseCase {
}
