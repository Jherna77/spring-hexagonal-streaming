package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.application.port.BackupServicePort;
import es.uned.tw.application.port.UserServicePort;
import es.uned.tw.domain.model.User;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.BackupRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The class Admin tools controller.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminToolsController {

    private final UserRequest userRequest;
    private final UserServicePort userService;
    private final BackupServicePort backupService;
    private final BackupRestMapper backupMapper;

    /**
     * Get backups in admin tool
     *
     * @param model the model
     * @return the template name
     */
    @SneakyThrows
    @GetMapping({"/admin-tools"})
    public String tools(final Model model) {
        model.addAttribute("backups",
                this.backupMapper.fromDomain(this.backupService.getBackups()));
        return "admin/admin-tools";
    }

    /**
     * Drop all backups.
     *
     * @param model the model
     * @return the url redirect to admin tools
     */
    @SneakyThrows
    @PostMapping({"/admin-backups/delete"})
    public String drop(final Model model) {
        log.info("Drop all backups");
        this.backupService.deleteBackups();
        return "redirect:/admin-tools";
    }

    /**
     * Perform backup with data snapshot.
     *
     * @param model the model
     * @return the url redirect to admin tools
     */
    @SneakyThrows
    @PostMapping({"/admin-backup/perform"})
    public String perform(final ModelMap model) {
        final User user = this.userService.getUserByEmail(this.userRequest.getEmail()).get();
        log.info("Performing backup user {}", user.getEmail());
        this.backupService.performBackup(user.getEmail());
        return "redirect:/admin-tools";
    }

    /**
     * Restore backup from data snapshot by id
     *
     * @param model the model
     * @param id    the id
     * @return the url redirect to admin tools
     */
    @SneakyThrows
    @PostMapping({"/admin-backup/restore"})
    public String restore(final ModelMap model, @RequestParam final Long id) {
        log.info("Restoring backup {}", id);
        this.backupService.restoreBackup(id);
        return "redirect:/admin-tools";
    }

    /**
     * Delete backup by id.
     *
     * @param model the model
     * @param id    the id
     * @return the url redirect to admin tools
     */
    @SneakyThrows
    @PostMapping({"/admin-backup/delete"})
    public String delete(final Model model, @RequestParam final Long id) {
        log.info("Deleting backup {}", id);
        this.backupService.deleteBackup(id);
        return "redirect:/admin-tools";
    }
}