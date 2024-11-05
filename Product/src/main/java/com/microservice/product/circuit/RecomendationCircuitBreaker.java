package com.microservice.product.circuit;

import com.microservice.product.WebService.vo.RecommendationVo;
import com.microservice.product.feing.RecommendInterface;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecomendationCircuitBreaker {



    @Autowired
    RecommendInterface recommendInterface;
    int count = 1;
    @CircuitBreaker(name = "Recommendation",fallbackMethod = "dummy")
    public List<RecommendationVo> getRecommendationVoList(Long productId) {
        System.out.println("service being called :" + count);
        count ++;
        return  recommendInterface.getRecommendationsByProductId(productId);

    }
    private List<RecommendationVo> dummy(Long id, Throwable throwable){
        System.out.println("Error :" +throwable.getMessage());
        List<RecommendationVo> list = new ArrayList<>();
        return  list;
    }


}
