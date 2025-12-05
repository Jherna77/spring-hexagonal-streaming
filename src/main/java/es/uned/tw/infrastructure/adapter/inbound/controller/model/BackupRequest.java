package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Backup request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BackupRequest {
    private Long id;
    private String user;
    private LocalDateTime perform;
    private LocalDateTime restore;
    private List<UserRoleRequest> roles;
    private List<UserRequest> users;
    private List<GenreRequest> genres;
    private List<DirectorRequest> directors;
    private List<ActorRequest> actors;
    private List<ContentTypeRequest> contentTypes;
    private List<FeatureRequest> features;
    private List<PlanRequest> plans;
    private List<ContentRequest> contents;
    private List<SubscriptionRequest> subscriptions;
    private List<RatingRequest> ratings;
    private List<PlayListRequest> playlists;
    private List<HistoryRequest> histories;
}
