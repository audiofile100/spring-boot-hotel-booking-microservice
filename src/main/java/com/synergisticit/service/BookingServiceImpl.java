package com.synergisticit.service;

import com.synergisticit.domain.Booking;
import com.synergisticit.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
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

    @Override
    public Booking findById(int bookingId) {
        Optional<Booking> opt = repo.findById(bookingId);
        return opt.orElse(null);
    }

    @Override
    public List<Booking> findByCid(int cid) {
        List<Booking> list = repo.findAllByCid(cid);
        for (Booking b : list) {
            if (b.getStatus().equals("upcoming") && LocalDate.now().isAfter(b.getCheckOutDate())) {
                b.setStatus("completed");
                repo.save(b);
            }
        }
        return repo.findAllByCid(cid);
    }

    @Override
    public void cancelBooking(int bookingId) {
        Optional<Booking> b = repo.findById(bookingId);
        if (b.isPresent()) {
            Booking booking = b.get();
            booking.setStatus("canceled");
            repo.save(booking);
        }
    }
}
