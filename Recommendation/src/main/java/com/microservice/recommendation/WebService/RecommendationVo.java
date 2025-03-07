package com.microservice.recommendation.WebService;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecommendationVo {
    private Long productId;
    private String rate;
    private String content;
}
