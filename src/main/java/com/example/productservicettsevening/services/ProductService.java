package com.example.productservicettsevening.services;

import com.example.productservicettsevening.dtos.PostAddNewProductDto;
import com.example.productservicettsevening.dtos.ProductRequestDto;
import com.example.productservicettsevening.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProductService {
    public List<Product> getAllProducts();
    public Product getSingleProduct(Long productId);
    public PostAddNewProductDto addNewProduct(PostAddNewProductDto postAddNewProductDto);

    public Product updateProduct(ProductRequestDto productRequestDto, Long productId);
    public Product deleteProduct(Long productId);

    public Product patchProduct(ProductRequestDto productRequestDto,Long productId);
}
