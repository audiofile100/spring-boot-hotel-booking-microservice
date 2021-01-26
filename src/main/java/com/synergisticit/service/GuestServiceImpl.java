package com.synergisticit.service;

import com.synergisticit.domain.Guest;
import com.synergisticit.repository.GuestRepository;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository repo;

    public GuestServiceImpl(GuestRepository repo) {
        this.repo = repo;
    }

    @Override
    public Guest save(Guest guest) {
        return repo.save(guest);
    }
}
