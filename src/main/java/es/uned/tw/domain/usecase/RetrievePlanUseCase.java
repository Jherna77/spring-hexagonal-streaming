package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.PlanException;
import es.uned.tw.domain.model.Plan;

import java.util.List;

/**
 * The interface Retrieve plan use case.
 */
public interface RetrievePlanUseCase {
    /**
     * Gets plans.
     *
     * @return the plans
     * @throws PlanException the plan exception
     */
    List<Plan> getPlans() throws PlanException;
}
