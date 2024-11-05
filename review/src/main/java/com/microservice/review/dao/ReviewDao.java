package com.microservice.review.dao;

import com.microservice.review.beans.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface ReviewDao extends JpaRepository<Review, Long> {

    Optional<Review> findById(Long id);
    void deleteById(Long id);
    Review save(Review product);
    Review findByProductId(Long productid);
    List<Review> findAll();
    @Query("select review from Review review where review.productId=:id")
    List<Review>findReviewByProductId(Long id);
}
