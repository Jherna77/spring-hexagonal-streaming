package es.uned.tw.application.port;

import es.uned.tw.domain.usecase.CreateHistoryUseCase;
import es.uned.tw.domain.usecase.RetrieveHistoryUseCase;

/**
 * The interface History service port.
 * It extends to implements all use cases related with user history operations
 */
public interface HistoryServicePort extends CreateHistoryUseCase,
        RetrieveHistoryUseCase {
}
