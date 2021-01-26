package com.synergisticit.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guestId;
    private String name;
    private int age;
    private String gender;

}
