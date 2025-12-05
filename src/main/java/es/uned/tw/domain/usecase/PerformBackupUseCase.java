package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.BackupException;

/**
 * The interface Perform backup use case.
 */
public interface PerformBackupUseCase {
    /**
     * Perform backup optional.
     *
     * @param user the user
     * @throws BackupException the backup exception
     */
    void performBackup(final String user) throws BackupException;
}
