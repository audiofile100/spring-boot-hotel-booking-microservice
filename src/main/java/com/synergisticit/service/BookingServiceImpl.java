package com.synergisticit.service;

import com.synergisticit.domain.Booking;
import com.synergisticit.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repo;

    public BookingServiceImpl(BookingRepository repo) {
        this.repo = repo;
    }

    @Override
    public Booking save(Booking booking) {
        return repo.save(booking);
    }
}
