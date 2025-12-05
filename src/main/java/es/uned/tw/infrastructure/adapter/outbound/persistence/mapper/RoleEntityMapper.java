package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import es.uned.tw.domain.model.UserRole;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.RoleEntity;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * The interface Role entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleEntityMapper {

    /**
     * To domain user role.
     *
     * @param role the role
     * @return the user role
     */
    UserRole toDomain(@NonNull final RoleEntity role);

    /**
     * To domain list.
     *
     * @param roles the roles
     * @return the list
     */
    List<UserRole> toDomain(@NonNull final List<RoleEntity> roles);

    /**
     * From domain role entity.
     *
     * @param role the role
     * @return the role entity
     */
    RoleEntity fromDomain(@NonNull final UserRole role);

    /**
     * From domain list.
     *
     * @param roles the roles
     * @return the list
     */
    List<RoleEntity> fromDomain(@NonNull final List<UserRole> roles);
}
