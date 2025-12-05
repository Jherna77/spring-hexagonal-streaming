package es.uned.tw.infrastructure.adapter.outbound.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type Actor entity.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "actors")
public class ActorEntity {
    @Id
    private Long id;
    private String name;
}