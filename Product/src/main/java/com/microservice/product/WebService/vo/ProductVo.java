package com.microservice.product.WebService.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class ProductVo {

    private Long id;
    private String name;
    private String weight;
    List<RecommendationVo> recommendationVoList;
    List<ReviewVo> reviewVoList;
}
