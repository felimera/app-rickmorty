package com.coderbyte.apprickmorty.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "system_errors")
public class SystemError {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "se_id")
    private Integer id;
    @Column(name = "se_code")
    private String code;
    @Column(name = "se_message")
    private String  message;
}
