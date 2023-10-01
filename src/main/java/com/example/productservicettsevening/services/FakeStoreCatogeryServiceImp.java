package com.example.productservicettsevening.services;

import com.example.productservicettsevening.Clients.FakeStoreClient;
import com.example.productservicettsevening.dtos.GetProductsByCategoryDto;
import com.example.productservicettsevening.dtos.ProductRequestDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCatogeryServiceImp implements CatogeryService {
    FakeStoreClient fakeStoreClient;
    public FakeStoreCatogeryServiceImp(FakeStoreClient fakeStoreClient){
        this.fakeStoreClient = fakeStoreClient;
    }
    @Override
    public String[] getAllCategories() {
        ResponseEntity<String[]> response = fakeStoreClient.getAllCategoriesApi();
        return response.getBody();
    }

    @Override
    public List<GetProductsByCategoryDto> getProductsByCategory(String name) {
        ResponseEntity<GetProductsByCategoryDto[]> response = fakeStoreClient.getProductsByCategoryApi(name);
        List<GetProductsByCategoryDto> answer = new ArrayList<>();
        GetProductsByCategoryDto[] temp = response.getBody();
        for(GetProductsByCategoryDto obj: temp){
            answer.add(obj);
        }
        return answer;
    }

}
