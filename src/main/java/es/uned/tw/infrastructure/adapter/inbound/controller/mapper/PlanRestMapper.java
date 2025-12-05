package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.Plan;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.PlanRequest;
import lombok.NonNull;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Plan rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {FeatureRestMapper.class})
public interface PlanRestMapper {

    /**
     * To domain plan.
     *
     * @param plan the plan
     * @return the plan
     */
    Plan toDomain(@NonNull final PlanRequest plan);

    /**
     * From domain plan request.
     *
     * @param plan the plan
     * @return the plan request
     */
    PlanRequest fromDomain(@NonNull final Plan plan);

    /**
     * From domain list.
     *
     * @param plan the plan
     * @return the list
     */
    List<PlanRequest> fromDomain(@NonNull final List<Plan> plan);
}
