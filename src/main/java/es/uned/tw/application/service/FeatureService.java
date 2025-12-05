package es.uned.tw.application.service;

import es.uned.tw.application.port.FeaturePersistencePort;
import es.uned.tw.application.port.FeatureServicePort;
import es.uned.tw.domain.model.Feature;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * The class Feature service to manage content feature operations in application domain.
 */
@RequiredArgsConstructor
public class FeatureService implements FeatureServicePort {

    private final FeaturePersistencePort featurePersistencePort;

    @Override
    public List<Feature> getFeatures() {
        return this.featurePersistencePort.getFeatures();
    }
}
