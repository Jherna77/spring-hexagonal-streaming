package es.uned.tw.infrastructure.adapter.outbound.persistence.mapper;

import es.uned.tw.domain.model.User;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.UserEntity;
import lombok.NonNull;
import org.mapstruct.*;

import java.util.List;

/**
 * The interface User entity mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {RoleEntityMapper.class, GenreEntityMapper.class,
                DirectorEntityMapper.class, ActorEntityMapper.class,})
public interface UserEntityMapper {

    /**
     * To domain user.
     *
     * @param user the user
     * @return the user
     */
    @Mapping(target = "genres", source = "favGenres")
    @Mapping(target = "directors", source = "favDirectors")
    @Mapping(target = "actors", source = "favActors")
    User toDomain(@NonNull final UserEntity user);

    /**
     * To domain list.
     *
     * @param users the users
     * @return the list
     */
    List<User> toDomain(@NonNull final List<UserEntity> users);

    /**
     * From domain user entity.
     *
     * @param user the user
     * @return the user entity
     */
    @InheritInverseConfiguration
    UserEntity fromDomain(@NonNull final User user);
}
