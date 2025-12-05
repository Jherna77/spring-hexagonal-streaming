package es.uned.tw.infrastructure.adapter.outbound.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * The type User entity.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity {
    @Id
    private Long id;
    @OneToOne
    private RoleEntity role;
    @Column(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String postalCode;
    private String city;
    private String province;
    private String country;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_genres",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<GenreEntity> favGenres;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_directors",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id"))
    private List<DirectorEntity> favDirectors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_actors",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<ActorEntity> favActors;
}