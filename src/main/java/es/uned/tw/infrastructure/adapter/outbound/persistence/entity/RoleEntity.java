package es.uned.tw.infrastructure.adapter.outbound.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type Role entity.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "role")
public class RoleEntity {
    @Id
    private Long id;
    @Column(unique = true)
    private String name;
    private String tag;
}
