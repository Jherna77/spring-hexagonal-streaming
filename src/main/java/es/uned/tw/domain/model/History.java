package es.uned.tw.domain.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * The type History.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class History {
    private Long id;
    private User user;
    private Content content;
    private LocalDateTime date;
}
