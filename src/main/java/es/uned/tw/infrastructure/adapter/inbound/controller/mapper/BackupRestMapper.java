package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.Backup;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.BackupRequest;
import lombok.NonNull;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Backup rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {UserRoleRestMapper.class, UserRestMapper.class, GenreRestMapper.class,
                DirectorRestMapper.class, ActorRestMapper.class, ContentTypeRestMapper.class,
                FeatureRestMapper.class, PlanRestMapper.class, ContentRestMapper.class,
                SubscriptionRestMapper.class, RatingRestMapper.class, PlayListRestMapper.class,
                HistoryRestMapper.class})
public interface BackupRestMapper {

    /**
     * To domain backup.
     *
     * @param user the user
     * @return the backup
     */
    Backup toDomain(@NonNull final BackupRequest user);

    /**
     * From domain backup request.
     *
     * @param user the user
     * @return the backup request
     */
    BackupRequest fromDomain(@NonNull final Backup user);

    /**
     * To domain list.
     *
     * @param users the users
     * @return the list
     */
    List<Backup> toDomain(@NonNull final List<BackupRequest> users);

    /**
     * From domain list.
     *
     * @param users the users
     * @return the list
     */
    List<BackupRequest> fromDomain(@NonNull final List<Backup> users);
}
