package es.uned.tw.repository;

import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.PlayListEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.UserContentPK;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringPlayListRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Play list repository test.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlayListRepositoryTest {
    @Autowired
    private SpringPlayListRepository playListRepository;

    /**
     * Test all play lists.
     */
    @Test
    void testAllPlayLists() {
        final List<PlayListEntity> playLists = this.playListRepository.findAll();
        assertThat(playLists).isNotNull();
        log.info("PlayList: {}", playLists);
    }

    /**
     * Test play list with user id 3 and content id 1.
     */
    @Test
    void testPlayListWithUserId3AndContentId1() {
        final Optional<PlayListEntity> playList = this.playListRepository.findById(new UserContentPK(3L, 1L));
        assertThat(playList.get()).isNotNull();
        assertThat(playList.get().getDate()).isNotNull();
        log.info("PlayList: {}", playList.get());

        assertThat(playList.get().getUser()).isNotNull();
        log.info("PlayList user: {}", playList.get().getUser());

        assertThat(playList.get().getContent()).isNotNull();
        log.info("PlayList content: {}", playList.get().getContent());
    }
}