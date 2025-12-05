package es.uned.tw.domain.model;

import lombok.*;

import java.util.List;

/**
 * The type User.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class User {
    private Long id;
    private UserRole role;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String province;
    private String country;
    private List<Genre> genres;
    private List<Director> directors;
    private List<Actor> actors;
}
