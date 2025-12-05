package es.uned.tw.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Content.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Content {
    private Long id;
    private LocalDateTime added;
    private ContentType type;
    private Feature feature;
    private String title;
    private String synopsis;
    private String production;
    private Integer premier;
    private List<Genre> genres;
    private List<Director> directors;
    private List<Actor> actors;
    private String cover;
    private String resourcePath;
    private Integer points;
}
