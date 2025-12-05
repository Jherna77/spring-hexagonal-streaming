package es.uned.tw.application.port;

import es.uned.tw.domain.model.PlayList;

import java.util.List;
import java.util.Optional;

/**
 * The interface Play list persistence port.
 * It defines all persisten operations to manage content play lists
 */
public interface PlayListPersistencePort {
    /**
     * Create play list optional.
     *
     * @param playList the play list
     * @return the optional
     */
    Optional<PlayList> createPlayList(final PlayList playList);

    /**
     * Gets play list by user id.
     *
     * @param userId the user id
     * @return the play list by user id
     */
    List<PlayList> getPlayListByUserId(final Long userId);

    /**
     * Gets play list by content id and user id.
     *
     * @param userId    the user id
     * @param contentId the content id
     * @return the play list by content id and user id
     */
    Optional<PlayList> getPlayListByContentIdAndUserId(final Long userId, final Long contentId);

    /**
     * Gets play lists.
     *
     * @return the play lists
     */
    List<PlayList> getPlayLists();

    /**
     * Delete play list.
     *
     * @param playList the play list
     */
    void deletePlayList(final PlayList playList);
}