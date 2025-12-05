package es.uned.tw.mapper;

import es.uned.tw.domain.model.PlayList;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.PlayListEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.UserContentPK;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.*;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringPlayListRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Play list entity mapper test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlayListEntityMapperTest {
    private final PlayListEntityMapper playListMapper = new PlayListEntityMapperImpl(
            new UserEntityMapperImpl(
                    new RoleEntityMapperImpl(), new GenreEntityMapperImpl(),
                    new DirectorEntityMapperImpl(), new ActorEntityMapperImpl()),
            new ContentEntityMapperImpl(
                    new ContentTypeEntityMapperImpl(), new FeatureEntityMapperImpl(),
                    new GenreEntityMapperImpl(), new DirectorEntityMapperImpl(),
                    new ActorEntityMapperImpl()));
    @Autowired
    private SpringPlayListRepository playListRepository;

    /**
     * Test play list entity mapper.
     */
    @Test
    void testPlayListEntityMapper() {
        final Optional<PlayListEntity> playListEntity = this.playListRepository.findById(new UserContentPK(3L, 1L));
        assertThat(playListEntity.get()).isNotNull();
        log.info("PlayList entity: {}", playListEntity.get());
        log.info("PlayList entity user: {}", playListEntity.get().getUser());
        log.info("PlayList entity content: {}", playListEntity.get().getContent());

        final PlayList playList = this.playListMapper.toDomain(playListEntity.get());
        assertThat(playList).isNotNull();
        assertThat(playList.getDate()).isNotNull();
        assertThat(playList.getDate()).isEqualTo(playListEntity.get().getDate());
        log.info("PlayList: {}", playList);

        assertThat(playList.getContent()).isNotNull();
        assertThat(playList.getContent().getId()).isEqualTo(playListEntity.get().getContent().getId());
        log.info("PlayList content: {}", playList.getContent());

        assertThat(playList.getUser()).isNotNull();
        assertThat(playList.getUser().getId()).isEqualTo(playListEntity.get().getUser().getId());
        log.info("PlayList user: {}", playList.getUser());
    }
}