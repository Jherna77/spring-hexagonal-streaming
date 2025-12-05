package es.uned.tw.infrastructure.adapter.outbound.persistence.repository.h2;

import es.uned.tw.application.port.PlayListPersistencePort;
import es.uned.tw.domain.model.PlayList;
import es.uned.tw.infrastructure.adapter.outbound.persistence.entity.PlayListEntity;
import es.uned.tw.infrastructure.adapter.outbound.persistence.mapper.PlayListEntityMapper;
import es.uned.tw.infrastructure.adapter.outbound.persistence.repository.SpringPlayListRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The class specific H2 provided implementation as play list repository adapter.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class H2PlayListRepositoryAdapter implements PlayListPersistencePort {

    private final SpringPlayListRepository playListRepository;
    private final PlayListEntityMapper playListMapper;

    @Override
    public Optional<PlayList> createPlayList(@NonNull final PlayList playList) {
        final PlayListEntity entity = this.playListMapper.fromDomain(playList);
        log.info("Creating {}", entity);
        return Optional.ofNullable(this.playListMapper.toDomain(this.playListRepository.save(entity)));
    }

    @Override
    public List<PlayList> getPlayListByUserId(@NonNull final Long userId) {
        log.info("Getting playlist by User(id={})", userId);
        return this.playListMapper.toDomain(this.playListRepository.findByUserIdOrderByDateAsc(userId));
    }

    @Override
    public Optional<PlayList> getPlayListByContentIdAndUserId(@NonNull final Long userId,
                                                              @NonNull final Long contentId) {
        log.info("Getting playlist by User(id={}) Content(id={})", userId, contentId);
        return this.playListRepository.findByUserIdAndContentId(userId, contentId).
                map(this.playListMapper::toDomain);
    }

    @Override
    public List<PlayList> getPlayLists() {
        log.info("Listing all histories");
        return this.playListRepository.findAll().stream().
                map(this.playListMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deletePlayList(@NonNull final PlayList playList) {
        log.info("Deleting playlist {}", playList);
        this.playListRepository.delete(this.playListMapper.fromDomain(playList));
    }
}