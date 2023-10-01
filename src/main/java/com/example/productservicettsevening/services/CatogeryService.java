package com.example.productservicettsevening.services;

import com.example.productservicettsevening.dtos.GetAllCategoriesDto;
import com.example.productservicettsevening.dtos.GetProductsByCategoryDto;
import com.example.productservicettsevening.dtos.ProductRequestDto;

import java.util.List;

public interface CatogeryService {
    public String[] getAllCategories();
    public List<GetProductsByCategoryDto> getProductsByCategory(String name);

}
