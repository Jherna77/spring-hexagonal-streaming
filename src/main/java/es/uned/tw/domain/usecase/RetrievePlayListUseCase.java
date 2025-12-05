package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.PlayListException;
import es.uned.tw.domain.model.PlayList;

import java.util.List;
import java.util.Optional;

/**
 * The interface Retrieve play list use case.
 */
public interface RetrievePlayListUseCase {
    /**
     * Gets play list by user id and content id.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @return the play list by user id and content id
     * @throws PlayListException the play list exception
     */
    Optional<PlayList> getPlayListByUserIdAndContentId(final Long userId, final Long contentId) throws PlayListException;

    /**
     * Gets play list by user id.
     *
     * @param userId the user id
     * @return the play list by user id
     * @throws PlayListException the play list exception
     */
    List<PlayList> getPlayListByUserId(final Long userId) throws PlayListException;

    /**
     * Gets play list.
     *
     * @return the play list
     * @throws PlayListException the play list exception
     */
    List<PlayList> getPlayList() throws PlayListException;
}
