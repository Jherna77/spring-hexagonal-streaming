package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.Genre;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.GenreRequest;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Genre rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreRestMapper {

    /**
     * To domain genre.
     *
     * @param genre the genre
     * @return the genre
     */
    Genre toDomain(@NonNull final GenreRequest genre);

    /**
     * From domain genre request.
     *
     * @param genre the genre
     * @return the genre request
     */
    GenreRequest fromDomain(@NonNull final Genre genre);

    /**
     * From domain list.
     *
     * @param genres the genres
     * @return the list
     */
    List<GenreRequest> fromDomain(@NonNull final List<Genre> genres);
}
