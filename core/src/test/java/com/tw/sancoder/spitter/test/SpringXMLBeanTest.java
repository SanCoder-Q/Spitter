package com.tw.sancoder.spitter.test;//Created by SanCoder on 7/28/15.

import org.apache.commons.dbcp.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.junit.*;

import com.tw.sancoder.spitter.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SpringXMLBeanTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private static Flyway flyway;
    private static ApplicationContext applicationContext;
    @BeforeClass
    public static void setUpClassFeature() {
        System.setProperty("spring.profiles.active", "test");
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://127.0.0.1:3306/spitter_test?characterEncoding=utf8", "root", "");
        flyway.setLocations("filesystem:./core/src/test/resources/db/migration");
    }

    @Before
    public void setUpFeature() {
        System.setOut(new PrintStream(outContent));
        flyway.clean();
        flyway.migrate();
    }

    @After
    public void cleanUpFeature() {
        flyway.clean();
        flyway.migrate();
        System.setOut(null);
    }

    @Test
    public void should_print_currect_str(){
        Messager messager = new Messager("hi");
        messager.print();
        BasicDataSource basicDataSource = (BasicDataSource)applicationContext.getBean("dataSource");
        System.out.println(basicDataSource.getUrl());
        messager.select(basicDataSource);
    }
}
