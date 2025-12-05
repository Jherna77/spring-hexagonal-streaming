package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.SubscriptionException;
import es.uned.tw.domain.model.Subscription;

import java.util.List;
import java.util.Optional;

/**
 * The interface Retrieve subscription use case.
 */
public interface RetrieveSubscriptionUseCase {
    /**
     * Gets subscription by user id.
     *
     * @param id the id
     * @return the subscription by user id
     * @throws SubscriptionException the subscription exception
     */
    Optional<Subscription> getSubscriptionByUserId(final Long id) throws SubscriptionException;

    /**
     * Gets subscriptions.
     *
     * @return the subscriptions
     * @throws SubscriptionException the subscription exception
     */
    List<Subscription> getSubscriptions() throws SubscriptionException;
}
