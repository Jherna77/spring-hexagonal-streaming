package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.Feature;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.FeatureRequest;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Feature rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeatureRestMapper {

    /**
     * To domain feature.
     *
     * @param feature the feature
     * @return the feature
     */
    Feature toDomain(@NonNull final FeatureRequest feature);

    /**
     * From domain feature request.
     *
     * @param feature the feature
     * @return the feature request
     */
    FeatureRequest fromDomain(@NonNull final Feature feature);

    /**
     * From domain list.
     *
     * @param feature the feature
     * @return the list
     */
    List<FeatureRequest> fromDomain(@NonNull final List<Feature> feature);
}
