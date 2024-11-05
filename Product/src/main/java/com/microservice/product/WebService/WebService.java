package com.microservice.product.WebService;

import com.microservice.product.Beans.Product;
import com.microservice.product.Service.facad.ProductService;
import com.microservice.product.WebService.vo.ProductVo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class WebService {

    ProductService productService;


    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleteProduct(Long id) {
         productService.deleteProduct(id);
    }


    @PutMapping("/")
    public Product updateProduct(Product product) {
        return productService.updateProduct(product);
    }


    @GetMapping("/find_with_associeted/{id}")
    public ProductVo findProductWithAssocietd(@PathVariable Long id){
         return productService.findWithAssociated(id);
    }

    @GetMapping("/find_with_associeted_test/{id}")
    public ProductVo findProductWithAssocietd_test(@PathVariable Long id){
        return productService.findWithAssociated_test(id);
    }



}
