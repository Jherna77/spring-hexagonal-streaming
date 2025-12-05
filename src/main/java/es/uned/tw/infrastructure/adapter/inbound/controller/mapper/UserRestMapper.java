package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.User;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRequest;
import lombok.NonNull;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface User rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {UserRoleRestMapper.class, GenreRestMapper.class,
                DirectorRestMapper.class, ActorRestMapper.class})
public interface UserRestMapper {

    /**
     * To domain user.
     *
     * @param user the user
     * @return the user
     */
    User toDomain(@NonNull final UserRequest user);

    /**
     * To domain list.
     *
     * @param users the users
     * @return the list
     */
    List<User> toDomain(@NonNull final List<UserRequest> users);

    /**
     * From domain user request.
     *
     * @param user the user
     * @return the user request
     */
    UserRequest fromDomain(@NonNull final User user);

    /**
     * From domain list.
     *
     * @param users the users
     * @return the list
     */
    List<UserRequest> fromDomain(@NonNull final List<User> users);
}
