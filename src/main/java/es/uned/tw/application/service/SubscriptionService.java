package es.uned.tw.application.service;

import es.uned.tw.application.port.PlanPersistencePort;
import es.uned.tw.application.port.SubscriptionPersistencePort;
import es.uned.tw.application.port.SubscriptionServicePort;
import es.uned.tw.application.port.UserPersistencePort;
import es.uned.tw.domain.model.Plan;
import es.uned.tw.domain.model.Subscription;
import es.uned.tw.domain.model.User;
import es.uned.tw.domain.type.PlanType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * The class Subscription service to manage subscription operations in application domain.
 */
@Slf4j
@RequiredArgsConstructor
public class SubscriptionService implements SubscriptionServicePort {

    private final SubscriptionPersistencePort subscriptionPersistencePort;
    private final UserPersistencePort userPersistencePort;
    private final PlanPersistencePort planPersistencePort;

    @Override
    public void createSubscription(@NonNull final Long userId, @NonNull final Long planId) {
        final User user = this.userPersistencePort.getUserById(userId).get();
        final Plan plan = this.planPersistencePort.getPlanById(planId).get();
        final Subscription subscription = Subscription.builder().
                user(user).plan(plan).
                start(LocalDateTime.now()).
                finish(plan.getDuration() == 0L ? null : LocalDateTime.now().plusMonths(plan.getDuration())).
                build();
        this.subscriptionPersistencePort.createSubscription(subscription);
    }

    @Override
    public Optional<Subscription> getSubscriptionByUserId(@NonNull final Long id) {
        return this.subscriptionPersistencePort.getSubscriptionByUserId(id);
    }

    @Override
    public List<Subscription> getSubscriptions() {
        return this.subscriptionPersistencePort.getSubscriptions();
    }

    @Override
    public void updateSubscription(@NonNull final Subscription subscription) {
        this.subscriptionPersistencePort.updateSubscription(subscription);
    }

    @Override
    public void updateSubscriptionPlan(@NonNull final Long userId, @NonNull final Long planId) {
        log.info("Selected subscription plan [UserId: {}] [PlanId: {}]", userId, planId);
        final Subscription subscription = this.getSubscriptionByUserId(userId).get();
        final Plan plan = this.planPersistencePort.getPlanById(planId).get();
        subscription.setPlan(plan);
        subscription.setStart(LocalDateTime.now());
        subscription.setFinish(plan.getDuration() == 0L ? null : LocalDateTime.now().plusMonths(plan.getDuration()));
        log.info("Updating subscription {}", subscription);
        this.updateSubscription(subscription);
    }

    @Override
    public void cancelSubscriptionPlan(@NonNull final Long userId) {
        log.info("Canceling subscription plan and set freemium [UserId: {}]", userId);
        this.updateSubscriptionPlan(userId, (long) PlanType.FREEMIUM.ordinal());
    }
}
