package com.microservice.product.client;


import com.microservice.product.WebService.vo.RecommendationVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RECOMMENDATION")
public interface RecommendationClient {
    @GetMapping("api/recommendations/productId/{productId}")
    List<RecommendationVo> getRecommendationsByProductId(@PathVariable Long productId) ;
}
