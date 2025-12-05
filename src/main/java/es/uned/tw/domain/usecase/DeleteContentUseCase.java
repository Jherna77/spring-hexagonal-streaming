package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.ContentException;

/**
 * The interface Delete content use case.
 */
public interface DeleteContentUseCase {
    /**
     * Delete content.
     *
     * @param id the id
     * @throws ContentException the content exception
     */
    void deleteContent(final Long id) throws ContentException;

    /**
     * Delete contents.
     *
     * @throws ContentException the content exception
     */
    void deleteContents() throws ContentException;
}
