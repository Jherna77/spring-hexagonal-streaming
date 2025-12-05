package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.SubscriptionEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringSubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Subscription repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SubscriptionRepositoryTest {
    @Autowired
    private SpringSubscriptionRepository subscriptionRepository;

    /**
     * Test all subscriptions.
     */
    @Test
    void testAllSubscriptions() {
        final List<SubscriptionEntity> subscriptions = this.subscriptionRepository.findAll();
        assertThat(subscriptions).isNotNull();
        assertThat(subscriptions).isNotEmpty();
        log.info("Subscription: {}", subscriptions);
    }

    /**
     * Test subscription with id 1.
     */
    @Test
    void testSubscriptionWithId1() {
        final Optional<SubscriptionEntity> subscription = this.subscriptionRepository.findById(1L);
        assertThat(subscription.get()).isNotNull();
        assertThat(subscription.get().getStart()).isNotNull();
        assertThat(subscription.get().getFinish()).isNotNull();
        log.info("Subscription: {}", subscription.get());

        assertThat(subscription.get().getUser()).isNotNull();
        log.info("Subscription user: {}", subscription.get().getUser());

        assertThat(subscription.get().getPlan()).isNotNull();
        log.info("Subscription plan: {}", subscription.get().getPlan());

    }
}
