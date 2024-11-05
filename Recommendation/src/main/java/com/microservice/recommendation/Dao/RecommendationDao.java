package com.microservice.recommendation.Dao;


import com.microservice.recommendation.Bean.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommendationDao extends JpaRepository<Recommendation, Long> {

    Optional<Recommendation> findById(Long id);
    void deleteById(Long id);
    Recommendation findByProductId(Long productId);
    Recommendation save(Recommendation product);
    List<Recommendation> findAll();
    @Query ("select recommend from Recommendation recommend where recommend.productId=:id")
    List<Recommendation> findRcommendationByIdProduit(Long id);

}
