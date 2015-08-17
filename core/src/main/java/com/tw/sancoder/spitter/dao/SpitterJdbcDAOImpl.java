package com.tw.sancoder.spitter.dao;//Created by SanCoder on 7/30/15.

import com.tw.sancoder.spitter.entity.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SpitterJdbcDAOImpl extends JdbcDaoSupport implements SpitterDAO {

    @Override
    public void addSpitter(Spitter spitter) {
        this.getJdbcTemplate().update("INSERT INTO spitters (name, password, email) VALUES (?, ?, ?)",
                spitter.getName(),
                spitter.getPassword(),
                spitter.getEmail());
    }

    @Override
    public List<Spitter> getAllSpitter() {

        List<Spitter> spitters;

        spitters = new ArrayList<Spitter>();
        List<Map<String,Object>> result = this.getJdbcTemplate().queryForList("SELECT * FROM spitters");
        for (Map<String, Object> spitterMap : result) {
            spitters.add(new Spitter(
                    (int)spitterMap.get("id"),
                    (String)spitterMap.get("name"),
                    (String)spitterMap.get("password"),
                    (String)spitterMap.get("email")
            ));
        }

        return spitters;
    }

    @Override
    public Spitter getSpitterById(int id) {
        Map<String, Object> spitterMap = this.getJdbcTemplate().queryForMap("SELECT * FROM spitters WHERE id = ?", new Object[]{id});
        return new Spitter(
                (int) spitterMap.get("id"),
                (String) spitterMap.get("name"),
                (String) spitterMap.get("password"),
                (String) spitterMap.get("email")
        );
    }
}
