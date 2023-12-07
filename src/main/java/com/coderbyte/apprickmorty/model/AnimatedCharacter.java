package com.coderbyte.apprickmorty.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
