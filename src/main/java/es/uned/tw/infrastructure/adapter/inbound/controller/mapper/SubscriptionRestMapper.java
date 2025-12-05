package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.Subscription;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.SubscriptionRequest;
import lombok.NonNull;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Subscription rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {UserRestMapper.class, PlanRestMapper.class})
public interface SubscriptionRestMapper {

    /**
     * To domain subscription.
     *
     * @param subscription the subscription
     * @return the subscription
     */
    Subscription toDomain(@NonNull final SubscriptionRequest subscription);

    /**
     * From domain subscription request.
     *
     * @param subscription the subscription
     * @return the subscription request
     */
    SubscriptionRequest fromDomain(@NonNull final Subscription subscription);

    /**
     * From domain list.
     *
     * @param subscription the subscription
     * @return the list
     */
    List<SubscriptionRequest> fromDomain(@NonNull final List<Subscription> subscription);
}
