package beautysalon.controller;

import beautysalon.model.entities.Review;
import beautysalon.model.entities.User;
import beautysalon.model.entities.WorkingDay;
import beautysalon.model.services.AppointmentsProcessor;
import beautysalon.model.services.ProceduresProcessor;
import beautysalon.model.services.ReviewsProcessor;
import beautysalon.model.services.UserProcessor;
import beautysalon.model.services.impl.AppointmentsService;
import beautysalon.model.services.impl.ProceduresService;
import beautysalon.model.services.impl.ReviewsService;
import beautysalon.model.services.impl.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    private AppointmentsProcessor appointmentsService;
    private ProceduresProcessor proceduresService;
    private ReviewsProcessor reviewsService;
    private UserProcessor userService;

    public ClientController(AppointmentsService appointmentsService,
                            ProceduresService proceduresService,
                            ReviewsService reviewsService,
                            UserService userService) {
        this.appointmentsService = appointmentsService;
        this.proceduresService = proceduresService;
        this.reviewsService = reviewsService;
        this.userService = userService;
    }

    @GetMapping("/menu")
    public String getClientMenu(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("user", user);
        return "/menu/client-menu";
    }

    @GetMapping("/appointments")
    public String getClientAppointments(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("clientAppointments", appointmentsService.getClientAppointments(user));
        return "client-appointments";
    }

    @GetMapping("/make-appointment")
    public String makeAppointment(Model model,
                                  @RequestParam(required = false) List<LocalDate> workingDays,
                                  String surnameEn) {

        model.addAttribute("masters", userService.getUsersByRole("master"));
        model.addAttribute("surnameEn", surnameEn);
        model.addAttribute("workingDays", workingDays);
        return "/schedule/client-master-schedule";
    }

    @PostMapping("/make-appointment/choose-master")
    public String chooseDateByMaster(Model model, String surnameEn) {
        List<WorkingDay> workingDays = userService.getAvailableMasterWorkingDays(surnameEn);

        List<LocalDate> dates = new ArrayList<>();

        workingDays.forEach(day -> dates.add(day.getDate()));
        return makeAppointment(model, dates, surnameEn);
    }

    @GetMapping("/procedures")
    public String getProcedures(Model model) {
        model.addAttribute("procedures", proceduresService.getAllProcedures());
        return "/procedures/client-procedures";
    }

    @GetMapping("/reviews")
    public String getClientReviews(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("reviews", reviewsService.getClientReviews(user));
        return "/reviews/client-reviews";
    }

    @GetMapping("/make-review")
    public String makeReview(Model model) {
        model.addAttribute("masters", userService.getUsersByRole("master"));

        return "/make-review";
    }

    @PostMapping("/make-review")
    public String sendReview(Integer masterId, String text, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        User master = userService.findById(masterId);

        Review review = Review.builder()
                                .date(LocalDate.now())
                                .clientId(user)
                                .masterId(master)
                                .text(text)
                                .build();

        reviewsService.createReview(review);
        return getClientReviews(model);
    }
}
