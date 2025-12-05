package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import es.uned.tw.domain.model.Genre;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.GenreEntity;
import lombok.NonNull;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Genre entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreEntityMapper {

    /**
     * To domain genre.
     *
     * @param genre the genre
     * @return the genre
     */
    Genre toDomain(@NonNull final GenreEntity genre);

    /**
     * To domain list.
     *
     * @param genres the genres
     * @return the list
     */
    List<Genre> toDomain(@NonNull final List<GenreEntity> genres);

    /**
     * From domain genre entity.
     *
     * @param genre the genre
     * @return the genre entity
     */
    @InheritInverseConfiguration
    GenreEntity fromDomain(@NonNull final Genre genre);
}
