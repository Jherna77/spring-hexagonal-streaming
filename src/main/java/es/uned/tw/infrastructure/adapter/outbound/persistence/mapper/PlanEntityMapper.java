package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import es.uned.tw.domain.model.Plan;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.PlanEntity;
import lombok.NonNull;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Plan entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {FeatureEntityMapper.class})
public interface PlanEntityMapper {

    /**
     * To domain plan.
     *
     * @param plan the plan
     * @return the plan
     */
    Plan toDomain(@NonNull final PlanEntity plan);

    /**
     * To domain list.
     *
     * @param plans the plans
     * @return the list
     */
    List<Plan> toDomain(@NonNull final List<PlanEntity> plans);

    /**
     * From domain plan entity.
     *
     * @param plan the plan
     * @return the plan entity
     */
    @InheritInverseConfiguration
    PlanEntity fromDomain(@NonNull final Plan plan);
}
