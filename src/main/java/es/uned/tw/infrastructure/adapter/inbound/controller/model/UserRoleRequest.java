package es.uned.tw.infrastructure.adapter.inbound.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The type User role request.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserRoleRequest {
    private Long id;
    private String name;
    private String tag;
}
