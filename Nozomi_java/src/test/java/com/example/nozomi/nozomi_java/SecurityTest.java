package com.example.nozomi.nozomi_java;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootTest
public class SecurityTest {
    @Test
    void contextLoads() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
    }
}
