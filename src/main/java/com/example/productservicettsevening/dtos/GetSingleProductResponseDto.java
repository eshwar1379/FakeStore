package com.example.productservicettsevening.dtos;

import com.example.productservicettsevening.models.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetSingleProductResponseDto {
   Product product;
}
