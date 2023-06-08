package com.example.screenspace.service;

import com.example.screenspace.model.Cinema;
import com.example.screenspace.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    public Optional<Cinema> getCinemaById(Integer cinemaId) {
        return cinemaRepository.findById(cinemaId);
    }

    public Cinema createCinema(Cinema Cinema) {
        return cinemaRepository.save(Cinema);
    }

    public Cinema updateCinema(Integer cinemaId, Cinema updatedCinema) {
        Optional<Cinema> existingCinema = cinemaRepository.findById(cinemaId);
        if (existingCinema.isPresent()) {
            updatedCinema.setId(cinemaId);
            return cinemaRepository.save(updatedCinema);
        }
        return null;
    }

    public boolean deleteCinema(Integer cinemaId) {
        Optional<Cinema> existingCinema = cinemaRepository.findById(cinemaId);
        if (existingCinema.isPresent()) {
            cinemaRepository.delete(existingCinema.get());
            return true;
        }
        return false;
    }
}
