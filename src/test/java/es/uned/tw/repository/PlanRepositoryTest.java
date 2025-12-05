package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.PlanEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringPlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Plan repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlanRepositoryTest {

    @Autowired
    private SpringPlanRepository planRepository;

    /**
     * Test all plans.
     */
    @Test
    void testAllPlans() {
        final List<PlanEntity> plans = this.planRepository.findAll();
        assertThat(plans).isNotNull();
        assertThat(plans).isNotEmpty();
        log.info("Plans: {}", plans);
    }

    /**
     * Test plan with id 1.
     */
    @Test
    void testPlanWithId1() {
        final Optional<PlanEntity> plan = this.planRepository.findById(1L);
        assertThat(plan.get()).isNotNull();
        assertThat(plan.get().getName()).isNotNull();
        assertThat(plan.get().getDescription()).isNotNull();
        assertThat(plan.get().getPrice()).isNotNull();
        assertThat(plan.get().getDuration()).isNotNull();
        log.info("Plan: {}", plan.get());

        assertThat(plan.get().getFeatures()).isNotNull();
        assertThat(plan.get().getFeatures()).isNotEmpty();
        log.info("Plan features: {}", plan.get().getFeatures());
    }
}
