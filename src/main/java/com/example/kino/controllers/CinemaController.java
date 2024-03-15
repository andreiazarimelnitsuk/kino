package com.example.kino.controllers;
import com.example.kino.models.CinemaSession;
import com.example.kino.services.CinemaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Controller
public class CinemaController {

    @Autowired
    private CinemaSessionService cinemaSessionService;

    @GetMapping("/schedule")
    public String showSchedule(Model model) {
        LocalDate today = LocalDate.now();
        LocalDate endOfWeek = today.plusDays(6); // assuming you want to show the schedule for the next 7 days
        List<CinemaSession> cinemaSessions = cinemaSessionService.getAllCinemaSessionsForWeek(today, endOfWeek);
        model.addAttribute("cinemaSessions", cinemaSessions);
        return "schedule";
    }

    @GetMapping("/filter")
    public String filterSchedule(@RequestParam String genre,
                                 @RequestParam Integer ageRestriction,
                                 @RequestParam LocalTime startTime,
                                 @RequestParam String language,
                                 Model model) {
        List<CinemaSession> filteredSessions = cinemaSessionService.filterCinemaSessions(genre, ageRestriction, startTime, language);
        model.addAttribute("cinemaSessions", filteredSessions);
        return "schedule";
    }
}