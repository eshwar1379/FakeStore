package com.example.productservicettsevening.dtos;

import com.example.productservicettsevening.models.Rating;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetProductsByCategoryDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
    private Rating rating;
}
