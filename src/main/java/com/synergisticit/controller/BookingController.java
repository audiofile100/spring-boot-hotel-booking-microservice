package com.synergisticit.controller;

import com.synergisticit.domain.Booking;
import com.synergisticit.repository.BookingRepository;
import com.synergisticit.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping(value = "/api/booking")
    public ResponseEntity<?> saveBookingDetails(@RequestBody Booking booking) {

        return new ResponseEntity<>(service.save(booking), HttpStatus.OK);
    }

    @GetMapping(value = "/api/booking/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable int id) {

        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/api/booking/cid/{cid}")
    public ResponseEntity<?> getBookingsByCid(@PathVariable int cid) {

        return new ResponseEntity<>(service.findByCid(cid), HttpStatus.OK);
    }

    @PutMapping(value = "/api/booking/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable int id) {
        log.debug("canceling booking " + id);
        service.cancelBooking(id);

        return new ResponseEntity<>("canceled booking " + id, HttpStatus.OK);
    }
}
