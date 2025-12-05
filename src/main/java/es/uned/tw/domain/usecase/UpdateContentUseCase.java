package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.ContentException;
import es.uned.tw.domain.model.Content;

/**
 * The interface Update content use case.
 */
public interface UpdateContentUseCase {
    /**
     * Update content optional.
     *
     * @param content the content
     * @throws ContentException the content exception
     */
    void updateContent(final Content content) throws ContentException;
}
