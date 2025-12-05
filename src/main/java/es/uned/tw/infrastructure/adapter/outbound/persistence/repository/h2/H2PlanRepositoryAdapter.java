package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.PlanPersistencePort;
import es.uned.tw.domain.model.Plan;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.PlanEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringPlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The class specific H2 provided implementation as plan repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2PlanRepositoryAdapter implements PlanPersistencePort {
    private final SpringPlanRepository planRepository;
    private final PlanEntityMapper planMapper;

    @Override
    public Optional<Plan> getPlanById(final Long id) {
        log.info("Getting plan {}", id);
        return this.planRepository.findById(id).map(this.planMapper::toDomain);
    }

    @Override
    public List<Plan> getPlans() {
        return this.planRepository.findAll().stream().
                map(this.planMapper::toDomain).collect(Collectors.toList());
    }
}
