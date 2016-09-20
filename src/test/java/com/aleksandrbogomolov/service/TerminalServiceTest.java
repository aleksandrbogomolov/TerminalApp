package com.aleksandrbogomolov.service;

import com.aleksandrbogomolov.TerminalApplication;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by aleksandrbogomolov on 9/18/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TerminalServiceTest {

    private static Logger logger = LoggerFactory.getLogger(TerminalServiceTest.class);

    @Rule
    public Stopwatch stopwatch = new Stopwatch() {
        private void logInfo(Description description, long nanos) {
            logger.info(String.format("+++ Test %s spent %d microseconds",
                    description.getMethodName(), TimeUnit.NANOSECONDS.toMicros(nanos)));
        }

        @Override
        protected void finished(long nanos, Description description) {
            logInfo(description, nanos);
        }
    };

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Before
    public void setUp() throws Exception {
        TerminalService.setBundle(ResourceBundle.getBundle("mainMessages", Locale.ENGLISH));
    }

    @Test
    public void checkForMorning() throws Exception {
        Clock clock = Clock.fixed(Instant.parse("2016-12-03T04:00:00.00Z"), ZoneId.of("Europe/Kiev"));
        TerminalService.setClock(clock);
        TerminalApplication.main(new String[0]);
        String output = this.capture.toString();
        String MORNING = "Good morning, World!";
        assertThat(output).contains(MORNING);
    }

    @Test
    public void checkForDay() throws Exception {
        Clock clock = Clock.fixed(Instant.parse("2016-12-03T07:00:00.00Z"), ZoneId.of("Europe/Kiev"));
        TerminalService.setClock(clock);
        TerminalApplication.main(new String[0]);
        String output = this.capture.toString();
        String DAY = "Good day, World!";
        assertThat(output).contains(DAY);
    }

    @Test
    public void checkForEvening() throws Exception {
        Clock clock = Clock.fixed(Instant.parse("2016-12-03T17:00:00.00Z"), ZoneId.of("Europe/Kiev"));
        TerminalService.setClock(clock);
        TerminalApplication.main(new String[0]);
        String output = this.capture.toString();
        String EVENING = "Good evening, World!";
        assertThat(output).contains(EVENING);
    }

    @Test
    public void checkForNight() throws Exception {
        Clock clock = Clock.fixed(Instant.parse("2016-12-03T21:00:00.00Z"), ZoneId.of("Europe/Kiev"));
        TerminalService.setClock(clock);
        TerminalApplication.main(new String[0]);
        String output = this.capture.toString();
        String NIGHT = "Good night, World!";
        assertThat(output).contains(NIGHT);
    }
}
