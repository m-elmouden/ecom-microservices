package com.microservice.review.webService;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewVo {
    private Long productId;
    private String author;
    private String subject;
    private String content;

}
