package es.uned.tw.infrastructure.adapter.outbound.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type User content pk.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserContentPK implements Serializable {

    private Long user;
    private Long content;

    @Override
    public int hashCode() {
        //return this.user.hashCode() + this.content.hashCode();
        return Objects.hash(this.user, this.content);
    }

    @Override
    public boolean equals(final Object obj) {
        boolean match = false;
        if (Objects.nonNull(obj) && obj instanceof UserContentPK) {
            UserContentPK ratingPK = (UserContentPK) obj;
            match = this.user.equals(ratingPK.getUser()) &&
                    this.content.equals(ratingPK.getContent());
        }
        return match;
    }
}
