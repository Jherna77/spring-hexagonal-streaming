package es.uned.tw.infrastructure.adapter.outbound.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type Genre entity.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "genres")
public class GenreEntity {
    @Id
    private Long id;
    private String name;
}