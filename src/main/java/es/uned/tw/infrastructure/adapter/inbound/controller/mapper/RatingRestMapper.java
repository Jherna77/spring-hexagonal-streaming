package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.Rating;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.RatingRequest;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Rating rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RatingRestMapper {

    /**
     * To domain rating.
     *
     * @param rating the rating
     * @return the rating
     */
    Rating toDomain(@NonNull final RatingRequest rating);

    /**
     * To domain list.
     *
     * @param ratings the ratings
     * @return the list
     */
    List<Rating> toDomain(@NonNull final List<RatingRequest> ratings);

    /**
     * From domain rating request.
     *
     * @param rating the rating
     * @return the rating request
     */
    RatingRequest fromDomain(@NonNull final Rating rating);

    /**
     * From domain list.
     *
     * @param rating the rating
     * @return the list
     */
    List<RatingRequest> fromDomain(@NonNull final List<Rating> rating);
}
