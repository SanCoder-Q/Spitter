package com.tw.sancoder.spitter.entity;//Created by SanCoder on 7/30/15.

import javax.persistence.*;

@Entity
@Table(name="spitters")
public class Spitter {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name="name")
    String name;

    @Column(name="password")
    String password;

    @Column(name="email")
    String email;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Spitter() {
    }

    public Spitter(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Spitter(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
