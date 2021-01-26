package com.synergisticit.controller;

import com.synergisticit.domain.Booking;
import com.synergisticit.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @PostMapping(value = "/api/booking")
    public ResponseEntity<?> saveBookingDetails(@RequestBody Booking booking) {

        return new ResponseEntity<>(bookingRepository.save(booking), HttpStatus.OK);
    }
}
