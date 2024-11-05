package com.microservice.product.feing;

import com.microservice.product.WebService.vo.ReviewVo;
import com.microservice.product.circuit.ReviewCircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="REVIEW",fallback = ReviewCircuitBreaker.class)
public interface ReviewInterface {

    @GetMapping("api/reviews/productId/{productId}")
    List<ReviewVo> getReviewsByProductId( @PathVariable Long productId);
}