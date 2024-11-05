package com.microservice.review.service.impl;

import com.microservice.review.beans.Review;
import com.microservice.review.dao.ReviewDao;
import com.microservice.review.service.facad.ReviewService;
import com.microservice.review.webService.ReviewVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewDao reviewDao;

    @Override
    public Review createReview(Review product) {
        Review productSaved= null;
        if(reviewDao.findByProductId(product.getProductId()) == null)
            productSaved = reviewDao.save(product);
        return productSaved;
    }

    @Override
    public Optional<Review> getReview(Long id) {
        return reviewDao.findById(id);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewDao.findAll();
    }

    @Override
    public void deleteReview(Long id) {
        reviewDao.deleteById(id);
    }

    @Override
    public Review updateReview(Review product) {
        return reviewDao.save(product);
    }

    @Override
    public List<ReviewVo> getReviewsByProductId(Long productId) {
        List<Review> recommendationList=reviewDao.findReviewByProductId(productId);
        List<ReviewVo> recommendationVoList=new ArrayList<>();
        if (!recommendationList.isEmpty()){
            for(Review recommendation : recommendationList){
                ReviewVo recommendationVo = new ReviewVo();
                recommendationVo.setProductId(recommendation.getProductId());
                recommendationVo.setContent(recommendation.getContent());
                recommendationVo.setAuthor(recommendation.getAuthor());
                recommendationVo.setSubject(recommendation.getSubject());
                recommendationVoList.add(recommendationVo);

            }}
        return recommendationVoList ;

    }
}
