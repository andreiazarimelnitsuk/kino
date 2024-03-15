package com.example.kino.services;
import com.example.kino.models.CinemaSession;
import com.example.kino.repository.CinemaSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class CinemaSessionService {

    @Autowired
    private CinemaSessionRepository cinemaSessionRepository;

    public List<CinemaSession> getAllCinemaSessions() {
        return cinemaSessionRepository.findAll();
    }

    public List<CinemaSession> filterCinemaSessions(String genre, Integer ageRestriction, LocalTime startTime, String language) {
        // Реализуйте логику фильтрации на основе жанра, возрастного ограничения, времени начала и языка
        // Ваш код здесь
        // Изменение: Принимаем дату и время начала сеанса
        LocalDateTime startDateTime = LocalDate.now().atTime(startTime);
        return cinemaSessionRepository.findByGenreAndAgeRestrictionAndSessionStartDateTimeAndLanguage(genre, ageRestriction, startDateTime, language);
    }

    public List<CinemaSession> getAllCinemaSessionsForWeek(LocalDate startDate, LocalDate endDate) {
        return cinemaSessionRepository.findAllBySessionDateBetween(startDate, endDate);
    }
}