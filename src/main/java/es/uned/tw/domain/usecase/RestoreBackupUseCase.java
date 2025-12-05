package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.BackupException;

/**
 * The interface Restore backup use case.
 */
public interface RestoreBackupUseCase {
    /**
     * Restore backup optional.
     *
     * @param id the id
     * @throws BackupException the backup exception
     */
    void restoreBackup(final Long id) throws BackupException;
}
