package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Content request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ContentRequest {
    private Long id;
    private LocalDateTime added;
    private FeatureRequest feature;
    private ContentTypeRequest type;
    private String title;
    private String synopsis;
    private String production;
    private Integer premier;
    private List<GenreRequest> genres;
    private List<DirectorRequest> directors;
    private List<ActorRequest> actors;
    private String cover;
    private String resourcePath;

    private String selectedGenre;
    private String selectedDirector;
    private String selectedActor;
    
    private List<String> selectedGenres;
    private List<String> selectedDirectors;
    private List<String> selectedActors;
}