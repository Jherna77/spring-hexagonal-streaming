package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.SubscriptionException;

/**
 * The interface Create subscription use case.
 */
public interface CreateSubscriptionUseCase {

    /**
     * Create subscription optional.
     *
     * @param userId the user id
     * @param planId the plan id
     * @throws SubscriptionException the subscription exception
     */
    void createSubscription(final Long userId, final Long planId) throws SubscriptionException;
}
