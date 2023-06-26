package com.example.screenspace.service;

import com.example.screenspace.model.Shows;
import com.example.screenspace.repository.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShowsService {
    private final ShowsRepository showsRepository;

    @Autowired
    public ShowsService(ShowsRepository ShowsRepository) {
        this.showsRepository = ShowsRepository;
    }

    public List<Shows> getAllShows() {
        return showsRepository.findAll();
    }

    public Optional<Shows> getShowById(Integer showId) {
        return showsRepository.findById(showId);
    }

    public Shows createShow(Shows Shows) {
        return showsRepository.save(Shows);
    }

    public Shows updateShow(Integer showId, Shows updatedShows) {
        Optional<Shows> existingShow = showsRepository.findById(showId);
        if (existingShow.isPresent()) {
            updatedShows.setId(showId);
            return showsRepository.save(updatedShows);
        }
        return null;
    }

    public boolean deleteShow(Integer showId) {
        Optional<Shows> existingShow = showsRepository.findById(showId);
        if (existingShow.isPresent()) {
            showsRepository.delete(existingShow.get());
            return true;
        }
        return false;
    }

    public List<Shows> getAllShowsByCinemaAndTheaterId(Integer cinemaId, Integer theaterId) {
        return showsRepository.findAllByCinemaIdAndTheaterId(cinemaId, theaterId);
    }

    public List<Shows> getAllShowsByMovieAndCinemaId(Integer movieId, Integer cinemaID) {
        return showsRepository.findAllByMovieIdAndCinemaId(movieId, cinemaID);
    }
}
