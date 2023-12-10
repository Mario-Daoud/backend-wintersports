package com.example.wintersport.service;

import com.example.wintersport.domain.Location;
import com.example.wintersport.domain.Review;
import com.example.wintersport.domain.User;
import com.example.wintersport.exception.ResourceNotFoundException;
import com.example.wintersport.repository.LocationRepository;
import com.example.wintersport.repository.ReviewRepository;
import com.example.wintersport.repository.UserRepository;
import com.example.wintersport.request.ReviewRequest;
import com.example.wintersport.response.ReviewLocationUserResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationrepository;

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, LocationRepository locationrepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.locationrepository = locationrepository;
    }

    public ReviewLocationUserResponse addReview(Long userId, Long locationId, ReviewRequest reviewRequest) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user"));
        Location location = locationrepository.findById(locationId).orElseThrow(() -> new ResourceNotFoundException("location"));

        Review review = new Review();
        review.setRating(reviewRequest.getRating());
        review.setDate(LocalDate.now());
        review.setUser(user);
        review.setLocation(location);
        reviewRepository.save(review);
        return new ReviewLocationUserResponse(review);
    }
}
