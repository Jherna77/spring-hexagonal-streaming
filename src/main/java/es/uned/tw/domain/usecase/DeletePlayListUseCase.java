package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.PlayListException;
import es.uned.tw.domain.model.PlayList;

/**
 * The interface Delete play list use case.
 */
public interface DeletePlayListUseCase {
    /**
     * Delete play list.
     *
     * @param playList the play list
     * @throws PlayListException the play list exception
     */
    void deletePlayList(final PlayList playList) throws PlayListException;
}
