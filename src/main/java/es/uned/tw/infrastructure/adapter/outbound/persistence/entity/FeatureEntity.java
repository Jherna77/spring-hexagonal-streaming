package es.uned.tw.infrastructure.adapter.outbound.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type Feature entity.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "features")
public class FeatureEntity {
    @Id
    private Long id;
    private String name;
    private String tag;
}
