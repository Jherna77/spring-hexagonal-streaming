package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.SubscriptionException;
import es.uned.tw.domain.model.Subscription;

/**
 * The interface Update subscription use case.
 */
public interface UpdateSubscriptionUseCase {
    /**
     * Update subscription optional.
     *
     * @param subscription the subscription
     * @throws SubscriptionException the subscription exception
     */
    void updateSubscription(final Subscription subscription) throws SubscriptionException;

    /**
     * Update subscription plan optional.
     *
     * @param userId the user id
     * @param planId the plan id
     * @throws SubscriptionException the subscription exception
     */
    void updateSubscriptionPlan(final Long userId, final Long planId) throws SubscriptionException;

    /**
     * Cancel subscription plan optional.
     *
     * @param userId the user id
     * @throws SubscriptionException the subscription exception
     */
    void cancelSubscriptionPlan(final Long userId) throws SubscriptionException;
}
