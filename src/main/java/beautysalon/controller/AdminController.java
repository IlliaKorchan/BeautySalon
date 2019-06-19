package beautysalon.controller;

import beautysalon.model.entities.User;
import beautysalon.model.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private AppointmentsProcessor appointmentsService;
    private ProceduresProcessor proceduresService;
    private UserProcessor userService;
    private WorkingDayProcessor workingDayService;
    private ReviewsProcessor reviewsService;

    public AdminController(AppointmentsProcessor appointmentsService,
                           ProceduresProcessor proceduresService,
                           UserProcessor userService,
                           WorkingDayProcessor workingDayService,
                           ReviewsProcessor reviewsService) {
        this.appointmentsService = appointmentsService;
        this.proceduresService = proceduresService;
        this.userService = userService;
        this.workingDayService = workingDayService;
        this.reviewsService = reviewsService;
    }

    @GetMapping("/menu")
    public String getAdminMenu() {
        return "/menu/admin-menu";
    }

    @GetMapping("/procedures")
    public String getProcedures(Model model) {
        model.addAttribute("procedures", proceduresService.getAllProcedures());
        return "/procedures/admin-procedures";
    }

    @GetMapping("/schedule")
    public String getAdminSchedulePage(Model model) {
        model.addAttribute("masters", userService.getUsersByRole("master"));
        return "/schedule/admin-master-schedule";
    }

    @PostMapping("/schedule")
    public String getMasterDates(Integer masterId, Model model) {
        User master = userService.findById(masterId);
        model.addAttribute("masterDates", workingDayService.getMasterWorkingDays(master));

        return "/schedule/admin-master-schedule";
    }

    @GetMapping("/reviews")
    public String getReviewsPage(Model model) {
        model.addAttribute("masters", userService.getUsersByRole("master"));
        return "/reviews/admin-reviews";
    }

    @PostMapping("/reviews")
    public String getMasterReviews(Integer masterId, Model model) {

        User master = userService.findById(masterId);
        model.addAttribute("reviews", reviewsService.getMasterReviews(master));
        return getReviewsPage(model);
    }

}
