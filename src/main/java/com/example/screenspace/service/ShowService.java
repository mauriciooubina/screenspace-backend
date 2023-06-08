package com.example.screenspace.service;

import com.example.screenspace.model.Show;
import com.example.screenspace.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    private final ShowRepository showRepository;

    @Autowired
    public ShowService(ShowRepository ShowRepository) {
        this.showRepository = ShowRepository;
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Optional<Show> getShowById(Integer showId) {
        return showRepository.findById(showId);
    }

    public Show createShow(Show Show) {
        return showRepository.save(Show);
    }

    public Show updateShow(Integer showId, Show updatedShow) {
        Optional<Show> existingShow = showRepository.findById(showId);
        if (existingShow.isPresent()) {
            updatedShow.setId(showId);
            return showRepository.save(updatedShow);
        }
        return null;
    }

    public boolean deleteShow(Integer showId) {
        Optional<Show> existingShow = showRepository.findById(showId);
        if (existingShow.isPresent()) {
            showRepository.delete(existingShow.get());
            return true;
        }
        return false;
    }

    public List<Show> getAllShowsByCinemaAndTheaterId(Integer cinemaID, Integer theaterId) {
        return showRepository.findAllByCinemaIdAndTheaterId(cinemaID, theaterId);
    }

    public List<Show> getAllShowsByMovieAndCinemaId(Integer movieId, Integer cinemaID) {
        return showRepository.findAllByMovieIdAndCinemaId(movieId, cinemaID);
    }
}
