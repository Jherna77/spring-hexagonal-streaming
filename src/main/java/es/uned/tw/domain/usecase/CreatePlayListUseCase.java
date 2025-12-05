package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.PlayListException;

/**
 * The interface Create play list use case.
 */
public interface CreatePlayListUseCase {
    /**
     * Create play list optional.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @throws PlayListException the play list exception
     */
    void createPlayList(final Long userId, final Long contentId) throws PlayListException;
}
