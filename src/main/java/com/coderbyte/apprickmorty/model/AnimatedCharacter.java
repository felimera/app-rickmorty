package com.coderbyte.apprickmorty.model;

import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class AnimatedCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ch_id")
    private Integer id;
    @Column(name = "ch_name")
    private String name;
    @Column(name = "ch_picture")
    private String picture;
    @Column(name = "ch_gender")
    private String gender;
    @Column(name = "ch_state")
    private String state;

    public AnimatedCharacter() {
    }

    public AnimatedCharacter(Integer id, String name, String picture, String gender, String state) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.gender = gender;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
