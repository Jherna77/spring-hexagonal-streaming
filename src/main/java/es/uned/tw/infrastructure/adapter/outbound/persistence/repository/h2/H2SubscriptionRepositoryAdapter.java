package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.SubscriptionPersistencePort;
import es.uned.tw.domain.model.Subscription;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.SubscriptionEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.SubscriptionEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringSubscriptionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The class specific H2 provided implementation as subscription repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2SubscriptionRepositoryAdapter implements SubscriptionPersistencePort {
    private final SpringSubscriptionRepository subscriptionRepository;
    private final SubscriptionEntityMapper subscriptionMapper;

    @Override
    public Optional<Subscription> createSubscription(@NonNull Subscription subscription) {
        final SubscriptionEntity entity = this.subscriptionMapper.fromDomain(subscription);
        if (Objects.isNull(entity.getId())) {
            entity.setId(this.subscriptionRepository.findTopByOrderByIdDesc().map(e -> e.getId() + 1L).orElse(0L));
        }

        log.info("Creating {}", entity);
        return Optional.ofNullable(this.subscriptionMapper.toDomain(this.subscriptionRepository.save(entity)));
    }

    @Override
    public Optional<Subscription> getSubscriptionByUserId(@NonNull Long id) {
        log.info("Getting subscription by User(id={})", id);
        return this.subscriptionRepository.findByUserId(id).map(this.subscriptionMapper::toDomain);
    }

    @Override
    public List<Subscription> getSubscriptions() {
        log.info("Listing all subscriptions");
        return this.subscriptionRepository.findAll().stream().
                map(this.subscriptionMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Subscription> updateSubscription(@NonNull Subscription subscription) {
        final SubscriptionEntity entity = this.subscriptionMapper.fromDomain(subscription);
        log.info("Updating {}", entity);
        return Optional.ofNullable(this.subscriptionMapper.toDomain(this.subscriptionRepository.save(entity)));
    }

}
