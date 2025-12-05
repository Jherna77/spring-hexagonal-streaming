package es.uned.tw.application.service;

import es.uned.tw.application.port.ContentPersistencePort;
import es.uned.tw.application.port.PlayListPersistencePort;
import es.uned.tw.application.port.PlayListServicePort;
import es.uned.tw.application.port.UserPersistencePort;
import es.uned.tw.domain.exception.PlayListException;
import es.uned.tw.domain.model.Content;
import es.uned.tw.domain.model.PlayList;
import es.uned.tw.domain.model.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * The class Play list service to manage playlist logical operations in application domain.
 */
@RequiredArgsConstructor
public class PlayListService implements PlayListServicePort {
    private final PlayListPersistencePort playListPersistence;
    private final UserPersistencePort userPersistence;
    private final ContentPersistencePort contentPersistencePort;

    @Override
    public void createPlayList(@NonNull final Long userId,
                               @NonNull final Long contentId) throws PlayListException {
        final Optional<User> user = this.userPersistence.getUserById(userId);
        final Optional<Content> content = this.contentPersistencePort.getContentById(contentId);
        final PlayList playList = PlayList.builder().
                user(user.get()).content(content.get()).date(LocalDateTime.now()).build();
        this.playListPersistence.createPlayList(playList);
    }

    @Override
    public Optional<PlayList> getPlayListByUserIdAndContentId(@NonNull final Long userId,
                                                              @NonNull final Long contentId) throws PlayListException {
        return this.playListPersistence.getPlayListByContentIdAndUserId(userId, contentId);
    }

    @Override
    public List<PlayList> getPlayListByUserId(@NonNull final Long userId) throws PlayListException {
        return List.of();
    }

    @Override
    public List<PlayList> getPlayList() throws PlayListException {
        return this.playListPersistence.getPlayLists();
    }

    @Override
    public void deletePlayList(@NonNull final PlayList playList) throws PlayListException {
        this.playListPersistence.deletePlayList(playList);
    }
}
