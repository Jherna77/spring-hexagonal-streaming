package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.application.port.ContentServicePort;
import es.uned.tw.application.port.UserServicePort;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.ContentRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.ContentTypeRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.UserRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.ContentRequest;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.ContentTypeRequest;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The class Content controller.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class ContentController {
    private final UserRequest userRequest;
    private final UserServicePort userService;
    private final UserRestMapper userMapper;
    private final ContentServicePort contentService;
    private final ContentRestMapper contentMapper;
    private final ContentTypeRestMapper contentTypeMapper;
    private final MessageSource messageSource;

    /**
     * Content types list.
     *
     * @return the list
     */
    @SneakyThrows
    @ModelAttribute("types")
    public List<ContentTypeRequest> types() {
        return this.contentTypeMapper.fromDomain(this.contentService.getContentTypesByUserId(
                this.userService.getUserByEmail(this.userRequest.getEmail()).get().getId()));
    }

    /**
     * Get contents for authorized user
     *
     * @param model the model
     * @return the template name
     */
    @SneakyThrows
    @GetMapping({"/content"})
    public String content(final Model model) {
        final UserRequest user = this.userMapper.fromDomain(
                this.userService.getUserByEmail(this.userRequest.getEmail()).get());
        final List<ContentRequest> contents =
                this.contentMapper.fromDomain(this.contentService.getContentsByUserId(user.getId()));

        final Map<String, List<List<ContentRequest>>> groups = new LinkedHashMap<>();
        groups.put("content.type.recommended", this.getContentsList(this.contentMapper.fromDomain(
                this.contentService.getContentsRecommendedByUserId(user.getId()))));
        groups.put("content.type.follow", this.getContentsList(this.contentMapper.fromDomain(
                this.contentService.getContentsPlayListByUserId(user.getId()))));
        groups.put("content.type.news", this.getContentsList(this.contentMapper.fromDomain(
                this.contentService.getContentsRecentByUserId(user.getId(), 10))));
        groups.putAll(this.getContentTypes(contents));

        model.addAttribute("contents", groups);
        return "content/content";
    }

    private Map<String, List<List<ContentRequest>>> getContentTypes(final List<ContentRequest> contents) {
        final Map<String, List<List<ContentRequest>>> groups = new LinkedHashMap<>();
        for (final ContentTypeRequest type : this.types()) {
            final List<ContentRequest> sublist = contents.stream().
                    filter(c -> Objects.equals(c.getType().getId(), type.getId())).collect(Collectors.toList());
            groups.put(type.getTag(), this.getContentsList(sublist));
        }
        return groups;
    }

    private List<List<ContentRequest>> getContentsList(final List<ContentRequest> contents) {
        final List<List<ContentRequest>> groups = new ArrayList<>();
        for (final ContentRequest content : contents) {
            if (groups.isEmpty() || groups.get(groups.size() - 1).size() % 5 == 0) {
                groups.add(new ArrayList<>());
            }
            groups.get(groups.size() - 1).add(content);
        }
        return groups;
    }
}