package es.uned.tw.application.service;

import es.uned.tw.application.port.PlanPersistencePort;
import es.uned.tw.application.port.PlanServicePort;
import es.uned.tw.domain.model.Plan;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * The class Plan service to manage subscription plans operations in application domain.
 */
@RequiredArgsConstructor
public class PlanService implements PlanServicePort {

    private final PlanPersistencePort planPersistencePort;

    @Override
    public List<Plan> getPlans() {
        return this.planPersistencePort.getPlans();
    }
}
