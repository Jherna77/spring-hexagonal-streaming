package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.ContentException;
import es.uned.tw.domain.model.Content;
import es.uned.tw.domain.model.ContentType;

import java.util.List;
import java.util.Optional;

/**
 * The interface Retrieve content use case.
 */
public interface RetrieveContentUseCase {
    /**
     * Gets content types.
     *
     * @return the content types
     */
    List<ContentType> getContentTypes();

    /**
     * Gets content types by user id.
     *
     * @param userId the user id
     * @return the content types by user id
     * @throws ContentException the content exception
     */
    List<ContentType> getContentTypesByUserId(final Long userId) throws ContentException;

    /**
     * Gets content by id.
     *
     * @param id the id
     * @return the content by id
     * @throws ContentException the content exception
     */
    Optional<Content> getContentById(final Long id) throws ContentException;

    /**
     * Gets contents by user id.
     *
     * @param userId the user id
     * @return the contents by user id
     * @throws ContentException the content exception
     */
    List<Content> getContentsByUserId(final Long userId) throws ContentException;

    /**
     * Gets contents recent.
     *
     * @param limit the limit
     * @return the contents recent
     * @throws ContentException the content exception
     */
    List<Content> getContentsRecent(final Integer limit) throws ContentException;

    /**
     * Gets contents recent by user id.
     *
     * @param userId the user id
     * @param limit  the limit
     * @return the contents recent by user id
     * @throws ContentException the content exception
     */
    List<Content> getContentsRecentByUserId(final Long userId, final Integer limit) throws ContentException;

    /**
     * Gets contents preferences by user id.
     *
     * @param userId the user id
     * @return the contents preferences by user id
     * @throws ContentException the content exception
     */
    List<Content> getContentsPreferencesByUserId(final Long userId) throws ContentException;

    /**
     * Gets contents.
     *
     * @return the contents
     */
    List<Content> getContents();

    /**
     * Gets contents recommended by user id.
     *
     * @param userId the user id
     * @return the contents recommended by user id
     * @throws ContentException the content exception
     */
    List<Content> getContentsRecommendedByUserId(final Long userId) throws ContentException;

    /**
     * Gets contents play list by user id.
     *
     * @param userId the user id
     * @return the contents play list by user id
     * @throws ContentException the content exception
     */
    List<Content> getContentsPlayListByUserId(final Long userId) throws ContentException;
}
