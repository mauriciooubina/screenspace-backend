package com.example.screenspace.service;

import com.example.screenspace.model.Show;
import com.example.screenspace.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    private final ShowRepository ShowRepository;

    @Autowired
    public ShowService(ShowRepository ShowRepository) {
        this.ShowRepository = ShowRepository;
    }

    public List<Show> getAllShows() {
        return ShowRepository.findAll();
    }

    public Optional<Show> getShowById(Integer showId) {
        return ShowRepository.findById(showId);
    }

    public Show createShow(Show Show) {
        return ShowRepository.save(Show);
    }

    public Show updateShow(Integer showId, Show updatedShow) {
        Optional<Show> existingShow = ShowRepository.findById(showId);
        if (existingShow.isPresent()) {
            updatedShow.setId(showId);
            return ShowRepository.save(updatedShow);
        }
        return null;
    }

    public boolean deleteShow(Integer showId) {
        Optional<Show> existingShow = ShowRepository.findById(showId);
        if (existingShow.isPresent()) {
            ShowRepository.delete(existingShow.get());
            return true;
        }
        return false;
    }
}
