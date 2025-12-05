package es.uned.tw.application.port;

import es.uned.tw.domain.model.Feature;

import java.util.List;

/**
 * The interface Feature persistence port.
 * It defines all persisten operations to manage content features
 */
public interface FeaturePersistencePort {
    /**
     * Gets features.
     *
     * @return the features
     */
    List<Feature> getFeatures();
}
