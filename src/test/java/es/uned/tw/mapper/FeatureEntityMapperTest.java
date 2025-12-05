package es.uned.tw.mapper;

import es.uned.tw.domain.model.Feature;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.FeatureEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.FeatureEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.FeatureEntityMapperImpl;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringFeatureRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Feature entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class FeatureEntityMapperTest {

    private final FeatureEntityMapper featureMapper = new FeatureEntityMapperImpl();
    @Autowired
    private SpringFeatureRepository featureRepository;

    /**
     * Test feature entity mapper.
     */
    @Test
    void testFeatureEntityMapper() {
        final Optional<FeatureEntity> featureEntity = this.featureRepository.findById(1L);
        assertThat(featureEntity.get()).isNotNull();
        log.info("Feature entity: {}", featureEntity.get());

        final Feature feature = this.featureMapper.toDomain(featureEntity.get());
        assertThat(feature).isNotNull();
        assertThat(feature.getId()).isNotNull();
        assertThat(feature.getName()).isNotNull();
        assertThat(feature.getId()).isEqualTo(featureEntity.get().getId());
        assertThat(feature.getName()).isEqualTo(featureEntity.get().getName());
        log.info("Feature: {}", feature);
    }
}
