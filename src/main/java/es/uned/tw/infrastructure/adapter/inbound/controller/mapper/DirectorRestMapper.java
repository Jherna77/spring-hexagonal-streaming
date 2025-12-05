package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.Director;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.DirectorRequest;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Director rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DirectorRestMapper {

    /**
     * To domain director.
     *
     * @param director the director
     * @return the director
     */
    Director toDomain(@NonNull final DirectorRequest director);

    /**
     * From domain director request.
     *
     * @param director the director
     * @return the director request
     */
    DirectorRequest fromDomain(@NonNull final Director director);

    /**
     * From domain list.
     *
     * @param directors the directors
     * @return the list
     */
    List<DirectorRequest> fromDomain(@NonNull final List<Director> directors);
}
