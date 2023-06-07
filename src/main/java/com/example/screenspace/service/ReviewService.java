package com.example.screenspace.service;

import com.example.screenspace.model.Review;
import com.example.screenspace.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository ReviewRepository) {
        this.reviewRepository = ReviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Integer reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public Review createReview(Review Review) {
        return reviewRepository.save(Review);
    }

    public Review updateReview(Integer reviewId, Review updatedReview) {
        Optional<Review> existingReview = reviewRepository.findById(reviewId);
        if (existingReview.isPresent()) {
            updatedReview.setId(reviewId);
            return reviewRepository.save(updatedReview);
        }
        return null;
    }

    public boolean deleteReview(Integer reviewId) {
        Optional<Review> existingReview = reviewRepository.findById(reviewId);
        if (existingReview.isPresent()) {
            reviewRepository.delete(existingReview.get());
            return true;
        }
        return false;
    }
}
