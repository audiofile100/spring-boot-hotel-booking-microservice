package com.synergisticit.service;

import com.synergisticit.domain.Booking;

import java.util.List;

public interface BookingService {

    Booking save(Booking booking);

    List<Booking> findByCid(int cid);

    void cancelBooking(int bookingId);
}
