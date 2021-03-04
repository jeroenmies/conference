package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.SessionJpaRepository;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionRepository repository;

    @Autowired
    private SessionJpaRepository jpaRepository;

    @Test
    public void test() throws Exception {
        List<Session> sessions = repository.getSessionsThatHaveName("Java");
        assertEquals(9, sessions.size());
    }

    @Test
    public void testJpaNot() throws Exception {
        List<Session> sessions = jpaRepository.findBySessionLengthNot(60);
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaNotLike() throws Exception {
        List<Session> sessions = jpaRepository.findBySessionNameNotLike("%Java%");
        assertEquals(62, sessions.size());
    }

}
