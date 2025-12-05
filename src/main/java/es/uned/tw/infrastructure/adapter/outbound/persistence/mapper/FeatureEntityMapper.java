package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import es.uned.tw.domain.model.Feature;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.FeatureEntity;
import lombok.NonNull;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Feature entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeatureEntityMapper {

    /**
     * To domain feature.
     *
     * @param feature the feature
     * @return the feature
     */
    Feature toDomain(@NonNull final FeatureEntity feature);

    /**
     * To domain list.
     *
     * @param features the features
     * @return the list
     */
    List<Feature> toDomain(@NonNull final List<FeatureEntity> features);

    /**
     * From domain feature entity.
     *
     * @param feature the feature
     * @return the feature entity
     */
    @InheritInverseConfiguration
    FeatureEntity fromDomain(@NonNull final Feature feature);
}
