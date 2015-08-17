package com.tw.sancoder.spitter.dao;//Created by SanCoder on 8/7/15.

import com.tw.sancoder.spitter.entity.Spitter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SpitterJpaDAOImpl implements SpitterDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSpitter(Spitter spitter) {
        entityManager.persist(spitter);
    }

    @Override
    public List<Spitter> getAllSpitter() {
        return entityManager.createQuery("from com.tw.sancoder.spitter.entity.Spitter").getResultList();
    }

    @Override
    public Spitter getSpitterById(int id) {
        return entityManager.find(Spitter.class, id);
    }
}
