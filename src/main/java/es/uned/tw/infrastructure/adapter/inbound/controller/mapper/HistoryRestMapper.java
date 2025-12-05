package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.History;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.HistoryRequest;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface History rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HistoryRestMapper {

    /**
     * To domain history.
     *
     * @param history the history
     * @return the history
     */
    History toDomain(@NonNull final HistoryRequest history);

    /**
     * To domain list.
     *
     * @param histories the histories
     * @return the list
     */
    List<History> toDomain(@NonNull final List<HistoryRequest> histories);

    /**
     * From domain history request.
     *
     * @param history the history
     * @return the history request
     */
    HistoryRequest fromDomain(@NonNull final History history);

    /**
     * From domain list.
     *
     * @param histories the histories
     * @return the list
     */
    List<HistoryRequest> fromDomain(@NonNull final List<History> histories);
}
