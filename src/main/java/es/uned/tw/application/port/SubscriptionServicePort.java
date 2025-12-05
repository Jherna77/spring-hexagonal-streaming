package es.uned.tw.application.port;

import es.uned.tw.domain.usecase.CreateSubscriptionUseCase;
import es.uned.tw.domain.usecase.RetrieveSubscriptionUseCase;
import es.uned.tw.domain.usecase.UpdateSubscriptionUseCase;

/**
 * The interface Subscription service port.
 * It extends to implements all use cases related with subscription operations
 */
public interface SubscriptionServicePort extends
        CreateSubscriptionUseCase, RetrieveSubscriptionUseCase, UpdateSubscriptionUseCase {
}
