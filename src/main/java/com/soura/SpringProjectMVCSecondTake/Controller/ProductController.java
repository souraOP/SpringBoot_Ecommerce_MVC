package com.soura.SpringProjectMVCSecondTake.Controller;

import com.soura.SpringProjectMVCSecondTake.Model.Product;
import com.soura.SpringProjectMVCSecondTake.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

//    @GetMapping("/products")
//    public List<Product> getProducts(){
//        return productService.getAllProducts();
//    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = productService.getProductById(id);

        if(product.getId() > 0){
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
