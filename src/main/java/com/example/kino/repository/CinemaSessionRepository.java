package com.example.kino.repository;
import com.example.kino.models.CinemaSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.time.LocalDate;
@Repository
public interface CinemaSessionRepository extends JpaRepository<CinemaSession, Long> {
    // Дополнительные методы для работы с данными о киносеансах могут быть добавлены здесь
    List<CinemaSession> findByGenreAndAgeRestrictionAndSessionDateAndLanguage(String genre, Integer ageRestriction, LocalDate sessionDate, String language);
    List<CinemaSession> findAllBySessionDateBetween(LocalDate startDate, LocalDate endDate);
    List<CinemaSession> findByGenreAndAgeRestrictionAndSessionStartDateTimeAndLanguage(String genre, Integer ageRestriction, LocalDateTime startDateTime, String language);
}

