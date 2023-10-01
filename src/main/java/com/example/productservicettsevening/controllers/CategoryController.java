package com.example.productservicettsevening.controllers;

import com.example.productservicettsevening.dtos.GetProductsByCategoryDto;
import com.example.productservicettsevening.dtos.ProductRequestDto;
import com.example.productservicettsevening.services.CatogeryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products/category")
public class CategoryController {

    CatogeryService catogeryService;
    public CategoryController(CatogeryService catogeryService){
        this.catogeryService = catogeryService;
    }

    @GetMapping()
    public ResponseEntity<String[]> getAllCategories() {
        MultiValueMap<String,String> header = new LinkedMultiValueMap<>();
        header.add("auth-token","foru");
        ResponseEntity<String[]> responseEntity = new ResponseEntity(catogeryService.getAllCategories(),
                header,
                HttpStatus.OK
        );
        return responseEntity;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List> getProductsByCategory(@PathVariable("name") String name){
        MultiValueMap<String,String> header = new LinkedMultiValueMap<>();
        header.add("auth-token","foru");
        ResponseEntity<List> responseEntity = new ResponseEntity(
                catogeryService.getProductsByCategory(name),
                HttpStatus.OK
        );
        return responseEntity;
    }

}
