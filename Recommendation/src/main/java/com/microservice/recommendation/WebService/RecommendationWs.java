package com.microservice.recommendation.WebService;


import com.microservice.recommendation.Bean.Recommendation;
import com.microservice.recommendation.Service.facad.RecommendationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("api/recommendations")
@AllArgsConstructor


public class RecommendationWs {

    @PostMapping("/")
    public Recommendation createRecommendation(@RequestBody Recommendation product) {
        return recommendationService.createRecommendation(product);
    }
    @GetMapping("/{id}")
    public Optional<Recommendation> getRecommendation(@PathVariable Long id) {
        return recommendationService.getRecommendation(id);
    }
    @GetMapping("/")
    public List<Recommendation> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleteRecommendation(Long id) {
         recommendationService.deleteRecommendation(id);
    }


    @PutMapping("/")
    public Recommendation updateRecommendation(Recommendation product) {
        return recommendationService.updateRecommendation(product);

    }

    @GetMapping("/productId/{productId}")
    public List<RecommendationVo> getRecommendationsByProductId(@PathVariable Long productId) {
        return recommendationService.getRecommendationsByProductId(productId);
    }


    private RecommendationService recommendationService;


}
