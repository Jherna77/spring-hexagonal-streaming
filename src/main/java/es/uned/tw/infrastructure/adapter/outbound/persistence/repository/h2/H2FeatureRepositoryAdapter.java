package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.FeaturePersistencePort;
import es.uned.tw.domain.model.Feature;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.FeatureEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringFeatureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The class specific H2 provided implementation as feature repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2FeatureRepositoryAdapter implements FeaturePersistencePort {
    private final SpringFeatureRepository featureRepository;
    private final FeatureEntityMapper featureMapper;

    @Override
    public List<Feature> getFeatures() {
        log.info("Listing all features");
        return this.featureRepository.findAll().stream().
                map(this.featureMapper::toDomain).collect(Collectors.toList());
    }
}
