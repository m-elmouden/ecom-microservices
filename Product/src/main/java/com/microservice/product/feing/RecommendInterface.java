package com.microservice.product.feing;


import com.microservice.product.WebService.vo.RecommendationVo;
import com.microservice.product.circuit.RecomendationCircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RECOMMENDATION", fallback = RecomendationCircuitBreaker.class)
 public interface RecommendInterface {

    @GetMapping("api/recommendations/productId/{productId}")
    List<RecommendationVo> getRecommendationsByProductId(@PathVariable Long productId) ;



}
