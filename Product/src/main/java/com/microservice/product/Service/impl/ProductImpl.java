package com.microservice.product.Service.impl;


import com.microservice.product.Beans.Product;
import com.microservice.product.Dao.ProductDao;
import com.microservice.product.Service.facad.ProductService;
import com.microservice.product.WebService.vo.ProductVo;
import com.microservice.product.WebService.vo.RecommendationVo;
import com.microservice.product.WebService.vo.ReviewVo;
import com.microservice.product.circuit.RecomendationCircuitBreaker;
import com.microservice.product.circuit.ReviewCircuitBreaker;
import com.microservice.product.feing.RecommendInterface;
import com.microservice.product.feing.ReviewInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProductImpl implements ProductService {

    @Autowired
    ProductDao productDao;
    @Autowired
    ReviewCircuitBreaker reviewCircuitBreaker;
    RecomendationCircuitBreaker recomendationCircuitBreaker;
    RecommendInterface recommendInterface;
    ReviewInterface reviewInterface;




    @Override
    public Product createProduct(Product product) {
        Product productSaved= null;
        if(productDao.findByWeight(product.getWeight())== null)
            productSaved = productDao.save(product);
        return productSaved;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
         productDao.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        if(productDao.findById(product.getId()).isEmpty()) return null;
        return productDao.save(product);
    }



    @Override
    public ProductVo findWithAssociated(Long id) {
        Optional<Product> product = productDao.findById(id);
        ProductVo productVo = new ProductVo();
        if(product.isPresent()){
            productVo.setId(product.get().getId());
            productVo.setName(product.get().getName());
            productVo.setWeight(product.get().getWeight());
            List<RecommendationVo> recommendationVoList = recomendationCircuitBreaker.getRecommendationVoList(product.get().getId());
            productVo.setRecommendationVoList(recommendationVoList);
            List<ReviewVo> reviewVoList= reviewCircuitBreaker.getReviewVoList(id);
            productVo.setReviewVoList(reviewVoList);
        }


        return productVo;
    }

    public ProductVo findWithAssociated_test(Long id) {
        Optional<Product> product = productDao.findById(id);
        ProductVo productVo = new ProductVo();
        if(product.isPresent()){
            productVo.setId(product.get().getId());
            productVo.setName(product.get().getName());
            productVo.setWeight(product.get().getWeight());
            List<RecommendationVo> recommendationVoList = recommendInterface.getRecommendationsByProductId(product.get().getId());
            productVo.setRecommendationVoList(recommendationVoList);
            List<ReviewVo> reviewVoList= reviewCircuitBreaker.getReviewVoList(product.get().getId());
            productVo.setReviewVoList(reviewVoList);
        }


        return productVo;
    }


}
