package com.aleksandrbogomolov;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by aleksandrbogomolov on 9/18/16.
 */
public class TerminalApplicationTest extends AbstractTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    ApplicationContext context;

    @Test
    public void testContextLoads() throws Exception {
        assertThat(this.context).isNotNull();
        assertThat(this.context.containsBean("terminalService")).isTrue();
        assertThat(this.context.containsBean("terminalApplication")).isTrue();
    }
}
