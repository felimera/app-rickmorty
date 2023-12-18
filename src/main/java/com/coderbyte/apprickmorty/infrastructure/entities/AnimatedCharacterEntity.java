package com.coderbyte.apprickmorty.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "characters")
public class AnimatedCharacterEntity {
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
