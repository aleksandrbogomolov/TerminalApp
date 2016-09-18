package com.aleksandrbogomolov;

import com.aleksandrbogomolov.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TerminalApplication implements CommandLineRunner {

    private final TerminalService service;

    @Autowired
    public TerminalApplication(TerminalService service) {
        this.service = service;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println(service.checkForTime());
        System.out.println("---------------------------");
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        SpringApplication.run(TerminalApplication.class, args);
    }
}
