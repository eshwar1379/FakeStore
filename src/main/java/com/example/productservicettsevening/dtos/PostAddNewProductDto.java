package com.example.productservicettsevening.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostAddNewProductDto {
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
