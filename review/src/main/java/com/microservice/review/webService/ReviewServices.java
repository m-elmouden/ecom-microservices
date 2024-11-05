package com.microservice.review.webService;


import com.microservice.review.beans.Review;
import com.microservice.review.service.facad.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reviews")
@AllArgsConstructor
public class ReviewServices {

    private ReviewService reviewService;

    @GetMapping("/productId/{productId}")
    public List<ReviewVo> getReviewsByProductId(@PathVariable Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }

    @PostMapping("/")
    public Review createReview(@RequestBody Review product) {
        return reviewService.createReview(product);
    }

    @GetMapping("/{id}")
    public Optional<Review> getReview(Long id) {
        return reviewService.getReview(id);
    }

    @GetMapping("/")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
    @DeleteMapping("/{id}")
    public void deleteReview(Long id) {
         reviewService.deleteReview(id);
    }
    @PutMapping("/")
    public Review updateReview(Review product) {
        return reviewService.updateReview(product);
    }




}
