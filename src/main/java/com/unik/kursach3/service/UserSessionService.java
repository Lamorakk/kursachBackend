//package com.unik.kursach3.service;
//
//
//import com.unik.kursach3.entity.UserSession;
//import com.unik.kursach3.repository.UserSessionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
//
//@Service
//public class UserSessionService {
//
//    @Autowired
//    private UserSessionRepository userSessionRepository;
//
//    public void saveSession(UserSession userSession) {
//        userSessionRepository.save(userSession);
//    }
//
//    public void deleteSession(Long userId) {
//        userSessionRepository.deleteByUserId(userId);
//    }
//
//
//    public boolean isSessionExpired(Long userId) {
//        UserSession session = userSessionRepository.findByUserId(userId).orElse(null);
//        if (session != null) {
//            long hoursDiff = ChronoUnit.HOURS.between(session.getLastLogin(), LocalDateTime.now());
//            if (hoursDiff > 24) {
//                deleteSession(userId); // Видалити сесію, якщо пройшло більше 24 годин
//                return true;
//            }
//        }
//        return false;
//    }
//}
