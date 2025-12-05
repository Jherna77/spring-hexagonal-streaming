package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.uned.tw.domain.model.Subscription;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.SubscriptionEntity;
import lombok.NonNull;

/**
 * The interface Subscription entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {UserEntityMapper.class, PlanEntityMapper.class})
public interface SubscriptionEntityMapper {

    /**
     * To domain subscription.
     *
     * @param subscription the subscription
     * @return the subscription
     */
    Subscription toDomain(@NonNull final SubscriptionEntity subscription);

    /**
     * To domain list.
     *
     * @param subscriptions the subscriptions
     * @return the list
     */
    List<Subscription> toDomain(@NonNull final List<SubscriptionEntity> subscriptions);

    /**
     * From domain subscription entity.
     *
     * @param subscription the subscription
     * @return the subscription entity
     */
    @InheritInverseConfiguration
    SubscriptionEntity fromDomain(@NonNull final Subscription subscription);

}
