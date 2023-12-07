package com.coderbyte.apprickmorty.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "called_tables")
public class CalledTables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ct_id")
    private Integer id;
    @Column(name = "ct_registration_date")
    private LocalDate registrationDate;
    @Column(name = "ct_type_request")
    private String typeRequest;
    @Column(name = "ct_login_information")
    private String loginInformation;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ct_error_id")
    private SystemError systemError;
}
