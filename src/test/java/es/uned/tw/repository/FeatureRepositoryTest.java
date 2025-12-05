package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.FeatureEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringFeatureRepository;
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
 * The type Feature repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class FeatureRepositoryTest {
    @Autowired
    private SpringFeatureRepository featureRepository;

    /**
     * Test all features.
     */
    @Test
    void testAllFeatures() {
        final List<FeatureEntity> features = this.featureRepository.findAll();
        assertThat(features).isNotNull();
        assertThat(features).isNotEmpty();
        log.info("Features: {}", features);
    }

    /**
     * Test feature with id 1.
     */
    @Test
    void testFeatureWithId1() {
        final Optional<FeatureEntity> feature = this.featureRepository.findById(1L);
        assertThat(feature.get()).isNotNull();
        assertThat(feature.get().getName()).isNotNull();
        log.info("Feature: {}", feature.get());
    }
}
