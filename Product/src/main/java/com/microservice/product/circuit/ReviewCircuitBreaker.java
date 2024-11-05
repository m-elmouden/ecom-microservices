package com.microservice.product.circuit;

import com.microservice.product.WebService.vo.RecommendationVo;
import com.microservice.product.WebService.vo.ReviewVo;
import com.microservice.product.feing.RecommendInterface;
import com.microservice.product.feing.ReviewInterface;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewCircuitBreaker {


    @Autowired
    ReviewInterface reviewInterface;



    @CircuitBreaker(name = "Review",fallbackMethod = "dummy")
    public List<ReviewVo> getReviewVoList(Long productId) {
        return  reviewInterface.getReviewsByProductId(productId);

    }
    private List<ReviewVo> dummy(Long id, Throwable throwable){
        System.out.println("error :"+throwable);
        List<ReviewVo> list = new ArrayList<>();
        return  list;
    }
}
