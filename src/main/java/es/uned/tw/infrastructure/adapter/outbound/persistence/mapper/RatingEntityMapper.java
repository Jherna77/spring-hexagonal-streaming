package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.uned.tw.domain.model.Rating;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.RatingEntity;
import lombok.NonNull;

/**
 * The interface Rating entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {UserEntityMapper.class, ContentEntityMapper.class})
public interface RatingEntityMapper {

    /**
     * To domain rating.
     *
     * @param rating the rating
     * @return the rating
     */
    Rating toDomain(@NonNull final RatingEntity rating);

    /**
     * To domain list.
     *
     * @param ratings the ratings
     * @return the list
     */
    List<Rating> toDomain(@NonNull final List<RatingEntity> ratings);

    /**
     * From domain rating entity.
     *
     * @param rating the rating
     * @return the rating entity
     */
    @InheritInverseConfiguration
    RatingEntity fromDomain(@NonNull final Rating rating);
}
