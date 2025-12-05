package es.uned.tw.infrastructure.adapter.outbound.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * The type Plan entity.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "plans")
public class PlanEntity {
    @Id
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    private Integer duration;
    private Double price;

    @ManyToMany
    @JoinTable(name = "plans_features",
            joinColumns = @JoinColumn(name = "plan_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private List<FeatureEntity> features;
}