package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.PlayList;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.PlayListRequest;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Play list rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayListRestMapper {

    /**
     * To domain play list.
     *
     * @param playList the play list
     * @return the play list
     */
    PlayList toDomain(@NonNull final PlayListRequest playList);

    /**
     * To domain list.
     *
     * @param playLists the play lists
     * @return the list
     */
    List<PlayList> toDomain(@NonNull final List<PlayListRequest> playLists);

    /**
     * From domain play list request.
     *
     * @param playList the play list
     * @return the play list request
     */
    PlayListRequest fromDomain(@NonNull final PlayList playList);

    /**
     * From domain list.
     *
     * @param playLists the play lists
     * @return the list
     */
    List<PlayListRequest> fromDomain(@NonNull final List<PlayList> playLists);
}
