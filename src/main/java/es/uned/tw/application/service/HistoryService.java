package es.uned.tw.application.service;

import es.uned.tw.application.port.ContentPersistencePort;
import es.uned.tw.application.port.HistoryPersistencePort;
import es.uned.tw.application.port.HistoryServicePort;
import es.uned.tw.application.port.UserPersistencePort;
import es.uned.tw.domain.exception.HistoryException;
import es.uned.tw.domain.model.Content;
import es.uned.tw.domain.model.History;
import es.uned.tw.domain.model.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * The class History service to manage user content history operations in application domain.
 */
@RequiredArgsConstructor
public class HistoryService implements HistoryServicePort {
    private final HistoryPersistencePort historyPersistence;
    private final UserPersistencePort userPersistence;
    private final ContentPersistencePort contentPersistence;

    @Override
    public Optional<History> createHistory(@NonNull final Long userId,
                                           @NonNull final Long contentId) throws HistoryException {
        final Optional<User> user = this.userPersistence.getUserById(userId);
        final Optional<Content> content = this.contentPersistence.getContentById(contentId);
        final History history = History.builder().
                user(user.get()).content(content.get()).
                date(LocalDateTime.now()).build();
        return this.historyPersistence.createHistory(history);
    }

    @Override
    public Long getHistoryCountByUserIdAndContentId(@NonNull final Long userId,
                                                    @NonNull final Long contentId) throws HistoryException {
        return this.historyPersistence.countHistoryByContentIdAndUserId(userId, contentId);
    }

    @Override
    public List<History> getHistory() throws HistoryException {
        return this.historyPersistence.getHistories();
    }
}
