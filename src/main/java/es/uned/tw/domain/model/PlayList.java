package es.uned.tw.domain.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * The type Play list.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class PlayList {
    private User user;
    private Content content;
    private LocalDateTime date;
}