package com.synergisticit.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private String customerMobile;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int hotelId;
    private String roomType;
    private double roomPrice;
    private double discount;
    private LocalDate bookedOn;
    private String status;
    private int totalRooms;
    private int totalGuests;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Guest> guestList = new ArrayList<>();
}
