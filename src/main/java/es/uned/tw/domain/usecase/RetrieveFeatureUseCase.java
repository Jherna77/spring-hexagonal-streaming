package es.uned.tw.domain.usecase;

import es.uned.tw.domain.model.Feature;

import java.util.List;

/**
 * The interface Retrieve feature use case.
 */
public interface RetrieveFeatureUseCase {
    /**
     * Gets features.
     *
     * @return the features
     */
    List<Feature> getFeatures();
}
