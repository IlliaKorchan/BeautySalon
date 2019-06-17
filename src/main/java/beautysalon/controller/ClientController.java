package beautysalon.controller;

import beautysalon.model.entities.Review;
import beautysalon.model.entities.User;
import beautysalon.model.repositories.ReviewRepository;
import beautysalon.model.repositories.UserRepository;
import beautysalon.model.services.AppointmentsService;
import beautysalon.model.services.ProceduresService;
import beautysalon.model.services.ReviewsService;
import beautysalon.model.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/client")
public class ClientController {
    private AppointmentsService appointmentsService;
    private ProceduresService proceduresService;
    private ReviewsService reviewsService;
    private UserService userService;
    private ReviewRepository reviewRepository;

    public ClientController(AppointmentsService appointmentsService,
                            ProceduresService proceduresService,
                            ReviewsService reviewsService,
                            UserService userService,
                            ReviewRepository reviewRepository) {
        this.appointmentsService = appointmentsService;
        this.proceduresService = proceduresService;
        this.reviewsService = reviewsService;
        this.userService = userService;
        this.reviewRepository = reviewRepository;
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
//                                  List<WorkingDay> workingDays,
                                  String surnameEn) {
        model.addAttribute("masters", userService.getMasters("master"));
        model.addAttribute("surnameEn", surnameEn);
        model.addAttribute("workingDays", userService.getAvailableMasterWorkingDays(surnameEn));
        return "client-master-schedule";
    }

    @PostMapping("/make-appointment/choose-master")
    public String chooseDateByMaster(Model model, String surnameEn) {
        model.addAttribute("surnameEn", surnameEn);
//        model.addAttribute("workingDays", userService.getAvailableMasterWorkingDays(surnameEn));
        return makeAppointment(model, surnameEn);
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
        model.addAttribute("masters", userService.getMasters("master"));

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
