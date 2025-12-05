package es.uned.tw.application.port;

import es.uned.tw.domain.usecase.CreateRatingUseCase;
import es.uned.tw.domain.usecase.DeleteRatingUseCase;
import es.uned.tw.domain.usecase.RetrieveRatingUseCase;
import es.uned.tw.domain.usecase.UpdateRatingUseCase;

/**
 * The interface Rating service port.
 * It extends to implements all use cases related with content rating operations
 */
public interface RatingServicePort extends CreateRatingUseCase,
        RetrieveRatingUseCase, UpdateRatingUseCase, DeleteRatingUseCase {
}
