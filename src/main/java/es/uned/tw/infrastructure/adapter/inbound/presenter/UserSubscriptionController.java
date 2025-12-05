package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.application.port.PlanServicePort;
import es.uned.tw.application.port.SubscriptionServicePort;
import es.uned.tw.application.port.UserServicePort;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.PlanRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.SubscriptionRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.UserRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.PlanRequest;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.SubscriptionRequest;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The class User subscription controller.
 */
@Slf4j
@Controller
@RequestMapping({"/user-subscription"})
@RequiredArgsConstructor
public class UserSubscriptionController {

    private final UserServicePort userService;
    private final UserRestMapper userMapper;
    private final UserRequest userRequest;

    private final PlanServicePort planService;
    private final PlanRestMapper planMapper;

    private final SubscriptionServicePort subscriptionService;
    private final SubscriptionRestMapper subscriptionMapper;

    /**
     * User user.
     *
     * @return the user request
     */
    @SneakyThrows
    @ModelAttribute("user")
    public UserRequest user() {
        return this.userMapper.fromDomain(this.userService.getUserByEmail(this.userRequest.getEmail()).get());
    }

    /**
     * Subscription request.
     *
     * @return the subscription request
     */
    @SneakyThrows
    @ModelAttribute("subscription")
    public SubscriptionRequest subscription() {
        return this.subscriptionMapper.fromDomain(
                this.subscriptionService.getSubscriptionByUserId(user().getId()).get());
    }

    /**
     * Plans list.
     *
     * @return the plans list
     */
    @SneakyThrows
    @ModelAttribute("plans")
    public List<PlanRequest> plans() {
        return this.planMapper.fromDomain(this.planService.getPlans());
    }

    /**
     * Get user subscription data.
     *
     * @return the template name
     */
    @GetMapping
    public String get() {
        return "user/user-subscription";
    }

    /**
     * Update subscription plan
     *
     * @param userRequest the user request
     * @param plan        the plan selected
     * @return the url redirect to user subscription successfully
     */
    @SneakyThrows
    @PostMapping(value = {"/{plan}"}, params = "submit")
    public String submit(@ModelAttribute("user") final UserRequest userRequest,
                         @PathVariable("plan") final Long plan) {
        log.info("Updating to plan {} for user {}", plan, userRequest);
        this.subscriptionService.updateSubscriptionPlan(userRequest.getId(), plan);
        return "redirect:/user-subscription?success";
    }

    /**
     * Cancel subscription plan.
     *
     * @param userRequest the user request
     * @param plan        the plan
     * @return the url redirect to user subscription canceled
     */
    @SneakyThrows
    @PostMapping(value = {"/{plan}"}, params = "cancel")
    public String cancel(@ModelAttribute("user") final UserRequest userRequest,
                         @PathVariable("plan") final Long plan) {
        log.info("Canceling current plan {} for user {}", plan, userRequest);
        this.subscriptionService.cancelSubscriptionPlan(userRequest.getId());
        return "redirect:/user-subscription?canceled";
    }
}