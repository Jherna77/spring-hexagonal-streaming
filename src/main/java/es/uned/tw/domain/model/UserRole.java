package es.uned.tw.domain.model;

import lombok.*;

/**
 * The type User role.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class UserRole {
    private Long id;
    private String name;
    private String tag;
}