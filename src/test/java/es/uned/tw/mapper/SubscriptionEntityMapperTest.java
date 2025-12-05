package es.uned.tw.mapper;

import es.uned.tw.domain.model.Subscription;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.SubscriptionEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.*;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringSubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Subscription entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SubscriptionEntityMapperTest {

    private final SubscriptionEntityMapper subscriptionMapper = new SubscriptionEntityMapperImpl(
            new UserEntityMapperImpl(new RoleEntityMapperImpl(), new GenreEntityMapperImpl(),
                    new DirectorEntityMapperImpl(), new ActorEntityMapperImpl()),
            new PlanEntityMapperImpl(new FeatureEntityMapperImpl()));
    @Autowired
    private SpringSubscriptionRepository subscriptionRepository;

    /**
     * Test subscription entity mapper.
     */
    @Test
    void testSubscriptionEntityMapper() {
        final Optional<SubscriptionEntity> subscriptionEntity = this.subscriptionRepository.findById(1L);
        assertThat(subscriptionEntity.get()).isNotNull();
        log.info("Subscription entity: {}", subscriptionEntity.get());
        log.info("Subscription entity user: {}", subscriptionEntity.get().getUser());
        log.info("Subscription entity plan: {}", subscriptionEntity.get().getPlan());

        final Subscription subscription = this.subscriptionMapper.toDomain(subscriptionEntity.get());
        assertThat(subscription).isNotNull();
        assertThat(subscription.getStart()).isNotNull();
        assertThat(subscription.getFinish()).isNotNull();
        assertThat(subscription.getStart()).isEqualTo(subscriptionEntity.get().getStart());
        assertThat(subscription.getFinish()).isEqualTo(subscriptionEntity.get().getFinish());
        log.info("Subscription: {}", subscription);

        assertThat(subscription.getPlan()).isNotNull();
        assertThat(subscription.getPlan().getId()).isEqualTo(subscriptionEntity.get().getPlan().getId());
        log.info("Subscription plan: {}", subscription.getPlan());

        assertThat(subscription.getUser()).isNotNull();
        assertThat(subscription.getUser().getId()).isEqualTo(subscriptionEntity.get().getUser().getId());
        log.info("Subscription user: {}", subscription.getUser());
    }
}
