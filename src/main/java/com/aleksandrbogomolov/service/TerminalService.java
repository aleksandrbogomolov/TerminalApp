package com.aleksandrbogomolov.service;

import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.Clock;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by aleksandrbogomolov on 9/18/16.
 */
@Service
public class TerminalService {

    private static ResourceBundle bundle = ResourceBundle.getBundle("mainMessages", Locale.getDefault());

    private static Clock clock = Clock.systemDefaultZone();

    static void setBundle(ResourceBundle bundle) {
        TerminalService.bundle = bundle;
    }

    static void setClock(Clock clock) {
        TerminalService.clock = clock;
    }

    public String checkForTime() throws UnsupportedEncodingException {
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
}
