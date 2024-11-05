package com.microservice.recommendation.Service.facad;

import com.microservice.recommendation.Bean.Recommendation;
import com.microservice.recommendation.WebService.RecommendationVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



public interface RecommendationService {

    Recommendation createRecommendation(Recommendation product);
    Optional<Recommendation> getRecommendation(Long id);
    List<Recommendation> getAllRecommendations();
    void deleteRecommendation(Long id);
    Recommendation updateRecommendation(Recommendation product);
    List<RecommendationVo> getRecommendationsByProductId(Long productId);
}
