package es.uned.tw.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Backup.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Backup {
    private Long id;
    private String user;
    private LocalDateTime perform;
    private LocalDateTime restore;
    private List<UserRole> roles;
    private List<User> users;
    private List<Genre> genres;
    private List<Director> directors;
    private List<Actor> actors;
    private List<ContentType> contentTypes;
    private List<Feature> features;
    private List<Plan> plans;
    private List<Content> contents;
    private List<Subscription> subscriptions;
    private List<Rating> ratings;
    private List<PlayList> playlists;
    private List<History> histories;
}