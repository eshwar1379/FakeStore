package com.example.productservicettsevening.controllers;

import com.example.productservicettsevening.dtos.PostAddNewProductDto;
import com.example.productservicettsevening.dtos.ProductRequestDto;
import com.example.productservicettsevening.dtos.GetSingleProductResponseDto;
import com.example.productservicettsevening.models.Product;
import com.example.productservicettsevening.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List> getAllProducts(){
        ResponseEntity<List> responseEntity = new ResponseEntity(
                productService.getAllProducts(),
                HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetSingleProductResponseDto> getSingleProduct(@PathVariable("productId") Long productId){
        GetSingleProductResponseDto getSingleProductResponseDto = new GetSingleProductResponseDto();
        getSingleProductResponseDto.setProduct(
                productService.getSingleProduct(productId)
        );
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("auth-token","noaccess4uheyheyhey");
        ResponseEntity<GetSingleProductResponseDto> responseEntity = new ResponseEntity(
                getSingleProductResponseDto,
                headers,
                HttpStatus.OK);
        return responseEntity;
    }
//    @GetMapping("/{productId}")
//    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){
//
//        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
//        headers.add("auth-token","noaccess4uheyheyhey");
//        ResponseEntity<Product> responseEntity = new ResponseEntity(
//                productService.getSingleProduct(productId),
//                headers,
//                HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody PostAddNewProductDto postAddNewProductDto){
        PostAddNewProductDto newProduct = productService.addNewProduct(postAddNewProductDto);
        ResponseEntity<Product>  response = new ResponseEntity(newProduct,HttpStatus.CREATED);
        return response;
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductRequestDto productRequestDto){

        ResponseEntity<Product> responseEntity = new ResponseEntity(
                productService.updateProduct(productRequestDto,productId),
                HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> changeProduct(@PathVariable("productId") Long productId, @RequestBody ProductRequestDto productRequestDto){
        ResponseEntity<Product> responseEntity = new ResponseEntity(
                productService.patchProduct(productRequestDto,productId),
                HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long productId){
        ResponseEntity<Product> responseEntity = new ResponseEntity(
                productService.deleteProduct(productId),
                HttpStatus.OK);
        return responseEntity;
    }
}
