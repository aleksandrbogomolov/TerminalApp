package com.aleksandrbogomolov.service;

import com.aleksandrbogomolov.AbstractTest;
import com.aleksandrbogomolov.TerminalApplication;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by aleksandrbogomolov on 9/18/16.
 */
public class TerminalServiceTest extends AbstractTest {

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Before
    public void setUp() throws Exception {
        TerminalService.setBundle(ResourceBundle.getBundle("mainMessages", Locale.ENGLISH));
    }

    @Test
    public void checkForMorning() throws Exception {
        Clock clock = Clock.fixed(Instant.parse("2016-12-03T04:15:30.00Z"), ZoneId.of("Europe/Kiev"));
        TerminalService.setClock(clock);
        TerminalApplication.main(new String[0]);
        String output = this.capture.toString();
        String MORNING = "Good morning, World!";
        assertThat(output).contains(MORNING);
    }

    @Test
    public void checkForDay() throws Exception {
        Clock clock = Clock.fixed(Instant.parse("2016-12-03T07:15:30.00Z"), ZoneId.of("Europe/Kiev"));
        TerminalService.setClock(clock);
        TerminalApplication.main(new String[0]);
        String output = this.capture.toString();
        String DAY = "Good day, World!";
        assertThat(output).contains(DAY);
    }

    @Test
    public void checkForEvening() throws Exception {
        Clock clock = Clock.fixed(Instant.parse("2016-12-03T17:15:30.00Z"), ZoneId.of("Europe/Kiev"));
        TerminalService.setClock(clock);
        TerminalApplication.main(new String[0]);
        String output = this.capture.toString();
        String EVENING = "Good evening, World!";
        assertThat(output).contains(EVENING);
    }

    @Test
    public void checkForNight() throws Exception {
        Clock clock = Clock.fixed(Instant.parse("2016-12-03T21:15:30.00Z"), ZoneId.of("Europe/Kiev"));
        TerminalService.setClock(clock);
        TerminalApplication.main(new String[0]);
        String output = this.capture.toString();
        String NIGHT = "Good night, World!";
        assertThat(output).contains(NIGHT);
    }
}
