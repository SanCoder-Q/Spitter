package com.tw.sancoder.spitter.dao;//Created by SanCoder on 7/30/15.

import com.tw.sancoder.spitter.entity.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpitterHibernateDAOImpl implements SpitterDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSpitter(Spitter spitter) {
        Session session = sessionFactory.openSession();
        session.save(spitter);
        session.close();
    }

    @Override
    public List<Spitter> getAllSpitter() {
        List<Spitter> spitters;
        Session session = sessionFactory.openSession();
        spitters = session.createQuery("from com.tw.sancoder.spitter.entity.Spitter").list();
        session.close();
        return spitters;
    }

    @Override
    public Spitter getSpitterById(int id) {
        Session session = sessionFactory.openSession();
        Spitter spitter = (Spitter)session.get(Spitter.class, id);
        session.close();
        return spitter;
    }
}
