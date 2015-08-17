package com.tw.sancoder.spitter;//Created by SanCoder on 7/28/15.

import com.tw.sancoder.spitter.dao.SpitterDAO;
import com.tw.sancoder.spitter.entity.Spitter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String args[]) {
        System.setProperty("spring.profiles.active", "dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

//        BasicDataSource basicDataSource = (BasicDataSource)applicationContext.getBean("dataSource");
//        System.out.println(basicDataSource.getUrl());
//
//        Messager messager = (Messager)applicationContext.getBean("messager");
//        messager.select(basicDataSource);

        SpitterDAO spitterDAO = (SpitterDAO)applicationContext.getBean("spitterDAOImpl");
        List<Spitter> spitters = spitterDAO.getAllSpitter();
    }
}
