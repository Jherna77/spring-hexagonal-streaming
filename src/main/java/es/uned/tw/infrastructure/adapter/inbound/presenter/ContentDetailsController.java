package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.application.port.*;
import es.uned.tw.domain.model.History;
import es.uned.tw.domain.model.PlayList;
import es.uned.tw.domain.model.Rating;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.ContentRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.ContentTypeRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.UserRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.ContentTypeRequest;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

/**
 * The class Content details controller.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class ContentDetailsController {
    private final UserRequest userRequest;
    private final UserServicePort userService;
    private final UserRestMapper userMapper;

    private final ContentServicePort contentService;
    private final ContentRestMapper contentMapper;
    private final ContentTypeRestMapper contentTypeMapper;

    private final RatingServicePort ratingService;
    private final PlayListServicePort playListService;
    private final HistoryServicePort historyService;

    /**
     * Rate range list.
     *
     * @return the list
     */
    @ModelAttribute("rates")
    public List<Integer> rateRange() {
        return List.of(1, 2, 3);
    }

    /**
     * ContentType list.
     *
     * @return the list
     */
    @SneakyThrows
    @ModelAttribute("types")
    public List<ContentTypeRequest> contentTypes() {
        return this.contentTypeMapper.fromDomain(this.contentService.getContentTypesByUserId(
                this.userService.getUserByEmail(this.userRequest.getEmail()).get().getId()));
    }

    /**
     * Get content detail by id
     *
     * @param model the model
     * @param id    the id
     * @return the template name
     */
    @SneakyThrows
    @GetMapping({"/content-detail/{id}"})
    public String detail(final Model model, @PathVariable final Long id) {
        final UserRequest user = this.userMapper.fromDomain(
                this.userService.getUserByEmail(this.userRequest.getEmail()).get());

        //Obtiene los datos del contenido
        model.addAttribute("content",
                this.contentMapper.fromDomain(this.contentService.getContentById(id).get()));

        //Obtiene el valor de votación y si existe en la lista de reproducción
        final Optional<Rating> rating = this.ratingService.getRatingByContentAndUserId(user.getId(), id);
        final Integer rate = rating.isEmpty() ? 0 :
                this.ratingService.getRatingByContentAndUserId(user.getId(), id).get().getRating();
        model.addAttribute("rating", rate);
        final boolean isPlayList = this.playListService.getPlayListByUserIdAndContentId(user.getId(), id).isPresent();
        model.addAttribute("playlist", isPlayList);
        log.info("Content {} with rate {} and playlist {}", id, rate, isPlayList);

        //Creación de un registro en el histórico como contenido visualizado
        final Optional<History> history = this.historyService.createHistory(user.getId(), id);
        log.info("Created visualization {}", history);

        //Obtiene el número de visualizaciones del contenido
        model.addAttribute("history",
                this.historyService.getHistoryCountByUserIdAndContentId(user.getId(), id));

        return "content/content-detail";
    }

    /**
     * Like and rate a content by id.
     *
     * @param id   the id
     * @param rate the rate
     * @return the url redirect to content detail
     */
    @SneakyThrows
    @PostMapping({"/content-detail/{id}/like/{rate}"})
    public String like(@PathVariable final Long id, @PathVariable final Integer rate) {
        final UserRequest user = this.userMapper.fromDomain(
                this.userService.getUserByEmail(this.userRequest.getEmail()).get());

        final Optional<Rating> rating = this.ratingService.getRatingByContentAndUserId(user.getId(), id);
        if (rating.isEmpty()) {
            log.info("Adding to rating content {}", id);
            this.ratingService.createRating(user.getId(), id, rate);
        } else if (rating.get().getRating() == rate) {
            log.info("Removing from rating content {}", id);
            this.ratingService.deleteRating(rating.get());
        } else {
            rating.get().setRating(rate);
            log.info("Updating content {} rating {} ", id, rating);
            this.ratingService.updateRating(rating.get());
        }
        return "redirect:/content-detail/" + id;
    }

    /**
     * Add content to user playlist to follow back playing.
     *
     * @param id the id
     * @return the url redirect to content details
     */
    @SneakyThrows
    @PostMapping({"/content-detail/{id}/playlist"})
    public String playlist(@PathVariable final Long id) {
        final UserRequest user = this.userMapper.fromDomain(
                this.userService.getUserByEmail(this.userRequest.getEmail()).get());

        final Optional<PlayList> playList = this.playListService.getPlayListByUserIdAndContentId(user.getId(), id);
        if (playList.isPresent()) {
            log.info("Removing from playlist content {}", id);
            this.playListService.deletePlayList(playList.get());
        } else {
            log.info("Adding to playlist content {}", id);
            this.playListService.createPlayList(user.getId(), id);
        }
        return "redirect:/content-detail/" + id;
    }
}