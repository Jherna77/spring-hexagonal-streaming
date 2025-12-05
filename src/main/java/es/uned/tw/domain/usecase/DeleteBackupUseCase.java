package es.uned.tw.domain.usecase;

import es.uned.tw.domain.exception.BackupException;

/**
 * The interface Delete backup use case.
 */
public interface DeleteBackupUseCase {
    /**
     * Delete backup.
     *
     * @param id the id
     * @throws BackupException the backup exception
     */
    void deleteBackup(final Long id) throws BackupException;

    /**
     * Delete backups.
     *
     * @throws BackupException the backup exception
     */
    void deleteBackups() throws BackupException;
}
