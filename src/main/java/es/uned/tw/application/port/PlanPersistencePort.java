package es.uned.tw.application.port;

import es.uned.tw.domain.model.Plan;

import java.util.List;
import java.util.Optional;

/**
 * The interface Plan persistence port.
 * It defines all persisten operations to manage subscription plans
 */
public interface PlanPersistencePort {
    /**
     * Gets plan by id.
     *
     * @param id the id
     * @return the plan by id
     */
    Optional<Plan> getPlanById(final Long id);

    /**
     * Gets plans.
     *
     * @return the plans
     */
    List<Plan> getPlans();
}
