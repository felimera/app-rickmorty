package com.coderbyte.apprickmorty.domian.models.in;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "called_tables")
public class CalledTablesEntity {
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
    private SystemErrorEntity systemErrorEntity;
}
