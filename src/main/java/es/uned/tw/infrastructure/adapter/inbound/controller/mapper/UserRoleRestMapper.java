package es.uned.tw.infrastructure.adapter.inbound.controller.mapper;

import es.uned.tw.domain.model.UserRole;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRoleRequest;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface User role rest mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserRoleRestMapper {

    /**
     * To domain user role.
     *
     * @param role the role
     * @return the user role
     */
    UserRole toDomain(@NonNull final UserRoleRequest role);

    /**
     * To domain list.
     *
     * @param roles the roles
     * @return the list
     */
    List<UserRole> toDomain(@NonNull final List<UserRoleRequest> roles);

    /**
     * From domain user role request.
     *
     * @param role the role
     * @return the user role request
     */
    UserRoleRequest fromDomain(@NonNull final UserRole role);

    /**
     * From domain list.
     *
     * @param roles the roles
     * @return the list
     */
    List<UserRoleRequest> fromDomain(@NonNull final List<UserRole> roles);
}
