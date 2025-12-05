package es.uned.tw.mapper;

import es.uned.tw.domain.model.Plan;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.PlanEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.FeatureEntityMapperImpl;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.PlanEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.PlanEntityMapperImpl;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringPlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Plan entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlanEntityMapperTest {

    private final PlanEntityMapper planMapper = new PlanEntityMapperImpl(new FeatureEntityMapperImpl());
    @Autowired
    private SpringPlanRepository planRepository;

    /**
     * Test plan entity mapper.
     */
    @Test
    void testPlanEntityMapper() {
        final Optional<PlanEntity> planEntity = this.planRepository.findById(1L);
        assertThat(planEntity.get()).isNotNull();
        log.info("Plan entity: {}", planEntity.get());
        log.info("Plan entity features: {}", planEntity.get().getFeatures());

        final Plan plan = this.planMapper.toDomain(planEntity.get());
        assertThat(plan).isNotNull();
        assertThat(plan.getId()).isNotNull();
        assertThat(plan.getName()).isNotNull();
        assertThat(plan.getDescription()).isNotNull();
        assertThat(plan.getPrice()).isNotNull();
        assertThat(plan.getDuration()).isNotNull();
        assertThat(plan.getId()).isEqualTo(planEntity.get().getId());
        assertThat(plan.getName()).isEqualTo(planEntity.get().getName());
        assertThat(plan.getDescription()).isEqualTo(planEntity.get().getDescription());
        assertThat(plan.getPrice()).isEqualTo(planEntity.get().getPrice());
        assertThat(plan.getDuration()).isEqualTo(planEntity.get().getDuration());
        log.info("Plan: {}", plan);

        assertThat(plan.getFeatures()).isNotNull();
        assertThat(plan.getFeatures().size()).isEqualTo(planEntity.get().getFeatures().size());
        log.info("Plan features: {}", plan.getFeatures());
    }
}
