package com.example.BANK_FAHRI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_nasabah")
public class User {

    @Id
    @Column(name = "UUID")
    private String uuid;

    @Column(name = "ID_CARD")
    private BigInteger id_card;

    @Column(name = "FULL_NAME")
    private String full_name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "BIRTH_PLACE")
    private String birth_place;

    @Column(name = "BIRTH_DATE")
    private Date birth_date;

    @Column(name = "PHONE")
    private String phone;
}