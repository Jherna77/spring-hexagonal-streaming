package es.uned.tw.infrastructure.adapter.inbound.presenter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The class Resources controller.
 */
@Slf4j
@Controller
@RequestMapping({"/resources"})
@RequiredArgsConstructor
public class ResourcesController {

    /**
     * Get application info.
     *
     * @return the template name
     */
    @GetMapping("/info")
    public String showInfo() {
        return "info";
    }
}
