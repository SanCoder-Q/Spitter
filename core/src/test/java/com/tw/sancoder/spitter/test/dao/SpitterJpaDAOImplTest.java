package com.tw.sancoder.spitter.test.dao;

import com.tw.sancoder.spitter.dao.SpitterDAO;
import com.tw.sancoder.spitter.entity.Spitter;
import junit.framework.Assert;
import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//Created by SanCoder on 7/30/15.
public class SpitterJpaDAOImplTest {

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
        flyway.clean();
        flyway.migrate();
    }

    @After
    public void cleanUpFeature() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void testAddSpitter() throws Exception {
        Spitter spitter = new Spitter("test", "test", "test@test.com");
        SpitterDAO spitterDAO = (SpitterDAO)applicationContext.getBean("spitterJpaDAOImpl");
        spitterDAO.addSpitter(spitter);
    }

    @Test
    public void testGetAllSpitter() throws Exception {
        SpitterDAO spitterDAO = (SpitterDAO)applicationContext.getBean("spitterJpaDAOImpl");
        List<Spitter> spitters = spitterDAO.getAllSpitter();
        Assert.assertEquals(spitters.get(0).getName(),"name1");
        Assert.assertEquals(spitters.get(1).getName(),"name2");
    }

    @Test
    public void testGetSpitterById() throws Exception {
        SpitterDAO spitterDAO = (SpitterDAO)applicationContext.getBean("spitterJpaDAOImpl");
        Spitter spitter = spitterDAO.getSpitterById(1);
        Assert.assertEquals(spitter.getName(),"name1");
    }
}