package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * The type User request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserRequest {
    private Long id;
    private UserRoleRequest role;
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
    private List<GenreRequest> genres;
    private List<DirectorRequest> directors;
    private List<ActorRequest> actors;

    private String selectedPlan;
    private List<String> selectedGenres;
    private List<String> selectedDirectors;
    private List<String> selectedActors;
}
