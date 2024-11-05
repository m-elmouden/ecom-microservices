package com.microservice.recommendation.Service.impl;


import com.microservice.recommendation.Bean.Recommendation;
import com.microservice.recommendation.Dao.RecommendationDao;
import com.microservice.recommendation.Service.facad.RecommendationService;
import com.microservice.recommendation.WebService.RecommendationVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RecommendationImpl implements RecommendationService {
    RecommendationDao recomendationDao;

    @Override
    public Recommendation createRecommendation(Recommendation product) {
        Recommendation productSaved= null;
        if(recomendationDao.findByProductId(product.getProductId())== null)
            productSaved = recomendationDao.save(product);
        return productSaved;
    }

    @Override
    public Optional<Recommendation> getRecommendation(Long id) {

        Optional<Recommendation> byId = recomendationDao.findById(id);

        return byId;
    }

    @Override
    public List<Recommendation> getAllRecommendations() {
        return recomendationDao.findAll();
    }

    @Override
    public void deleteRecommendation(Long id) {
        recomendationDao.deleteById(id);
    }

    @Override
    public Recommendation updateRecommendation(com.microservice.recommendation.Bean.Recommendation product) {
        return recomendationDao.save(product);
    }

    @Override
    public List<RecommendationVo> getRecommendationsByProductId(Long productId) {
        List<Recommendation> recommendationList=recomendationDao.findRcommendationByIdProduit(productId);
        List<RecommendationVo> recommendationVoList=new ArrayList<>();
        if (!recommendationList.isEmpty()){
       for(Recommendation recommendation : recommendationList){
           RecommendationVo recommendationVo = new RecommendationVo();
           recommendationVo.setProductId(recommendation.getProductId());
           recommendationVo.setContent(recommendation.getContent());
           recommendationVo.setRate(recommendation.getRate());
           recommendationVoList.add(recommendationVo);

       }}
       return recommendationVoList ;

    }
}
