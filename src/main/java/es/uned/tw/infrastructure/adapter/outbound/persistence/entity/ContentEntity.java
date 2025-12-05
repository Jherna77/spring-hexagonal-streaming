package es.uned.tw.infrastructure.adapter.outbound.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Content entity.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "contents")
public class ContentEntity {
    @Id
    private Long id;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime added;
    @OneToOne
    private FeatureEntity feature;
    @OneToOne
    private ContentTypeEntity type;
    private String title;
    private String synopsis;
    private String production;
    private Integer premier;
    private String cover;
    @Column(name = "resource_path")
    private String resourcePath;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contents_genres",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<GenreEntity> genres;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contents_directors",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id"))
    private List<DirectorEntity> directors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contents_actors",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<ActorEntity> actors;
}