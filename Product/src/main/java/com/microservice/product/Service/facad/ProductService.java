package com.microservice.product.Service.facad;

import com.microservice.product.Beans.Product;
import com.microservice.product.WebService.vo.ProductVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



public interface ProductService {
    Product createProduct(Product product);
    Optional<Product> getProduct(Long id);
    List<Product> getAllProducts();
    void deleteProduct(Long id);
    Product updateProduct(Product product);
    ProductVo findWithAssociated(Long id);
    ProductVo findWithAssociated_test(Long id);

}
