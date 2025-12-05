package es.uned.tw.domain.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * The type Rating.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Rating {
    private User user;
    private Content content;
    private Integer rating;
    private LocalDateTime date;
}
