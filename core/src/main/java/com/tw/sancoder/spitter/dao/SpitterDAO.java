package com.tw.sancoder.spitter.dao;//Created by SanCoder on 8/1/15.

import com.tw.sancoder.spitter.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SpitterDAO {

    @Transactional(propagation = Propagation.REQUIRED)
    void addSpitter(Spitter spitter);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    List<Spitter> getAllSpitter();

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    Spitter getSpitterById(int id);
}
