package com.microservice.product.client;

import com.microservice.product.WebService.vo.ReviewVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "REVIEW")
public interface ReviewClient {

    @GetMapping("api/reviews/productId/{productId}")
    List<ReviewVo> getReviewsByProductId(@PathVariable Long productId);
}