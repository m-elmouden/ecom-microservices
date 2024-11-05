package com.microservice.review.service.facad;


import com.microservice.review.beans.Review;
import com.microservice.review.webService.ReviewVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ReviewService {

    Review createReview(Review product);
    Optional<Review> getReview(Long id);
    List<Review> getAllReviews();
    void deleteReview(Long id);
    Review updateReview(Review product);
    List<ReviewVo> getReviewsByProductId(Long productId);
}
