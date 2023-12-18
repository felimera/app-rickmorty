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
@Table(name = "system_errors")
public class SystemErrorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "se_id")
    private Integer id;
    @Column(name = "se_code")
    private String code;
    @Column(name = "se_status")
    private String status;
    @Column(name = "se_message")
    private String message;
}
