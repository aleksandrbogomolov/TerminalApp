package com.aleksandrbogomolov;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.time.Clock;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication
public class TerminalApplication implements CommandLineRunner {

    private static ResourceBundle bundle = ResourceBundle.getBundle("mainMessages", Locale.getDefault());

    private static Clock clock = Clock.systemDefaultZone();

    static void setBundle(ResourceBundle bundle) {
        TerminalApplication.bundle = bundle;
    }

    static void setClock(Clock clock) {
        TerminalApplication.clock = clock;
    }

    private String checkForTime() throws UnsupportedEncodingException {
        if (isBetween(LocalTime.of(6, 0), LocalTime.of(9, 0))) {
            return new String(bundle.getString("good.morning").getBytes("ISO-8859-1"));
        } else if (isBetween(LocalTime.of(9, 0), LocalTime.of(19, 0))) {
            return new String(bundle.getString("good.day").getBytes("ISO-8859-1"));
        } else if (isBetween(LocalTime.of(19, 0), LocalTime.of(23, 0))) {
            return new String(bundle.getString("good.evening").getBytes("ISO-8859-1"));
        } else return new String(bundle.getString("good.night").getBytes("ISO-8859-1"));
    }

    private boolean isBetween(LocalTime of, LocalTime of2) {
        return LocalTime.now(clock).toSecondOfDay() >= of.toSecondOfDay() && LocalTime.now(clock).isBefore(of2);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println(checkForTime());
        System.out.println("---------------------------");
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        SpringApplication.run(TerminalApplication.class, args);
    }
}
