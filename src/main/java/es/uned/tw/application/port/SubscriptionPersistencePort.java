package es.uned.tw.application.port;

import es.uned.tw.domain.model.Subscription;

import java.util.List;
import java.util.Optional;

/**
 * The interface Subscription persistence port.
 * It defines all persisten operations to manage user subscriptions
 */
public interface SubscriptionPersistencePort {
    /**
     * Create subscription optional.
     *
     * @param subscription the subscription
     * @return the optional
     */
    Optional<Subscription> createSubscription(final Subscription subscription);

    /**
     * Gets subscription by user id.
     *
     * @param id the id
     * @return the subscription by user id
     */
    Optional<Subscription> getSubscriptionByUserId(final Long id);

    /**
     * Gets subscriptions.
     *
     * @return the subscriptions
     */
    List<Subscription> getSubscriptions();

    /**
     * Update subscription optional.
     *
     * @param subscription the subscription
     * @return the optional
     */
    Optional<Subscription> updateSubscription(final Subscription subscription);
}
 