package com.example.productservicettsevening.Clients;

import com.example.productservicettsevening.dtos.GetProductsByCategoryDto;
import com.example.productservicettsevening.dtos.PostAddNewProductDto;
import com.example.productservicettsevening.dtos.ProductRequestDto;
import com.example.productservicettsevening.models.Category;
import com.example.productservicettsevening.models.Product;
import com.example.productservicettsevening.services.CatogeryService;
import com.example.productservicettsevening.services.ProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class FakeStoreClient{
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return (ResponseEntity)restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    public ResponseEntity<ProductRequestDto[]> getAllProductsApi() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductRequestDto[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                ProductRequestDto[].class);
        return response;
    }

    public ResponseEntity<ProductRequestDto> getSingleProductApi(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductRequestDto> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                ProductRequestDto.class,
                productId
        );
        return response;
    }

    public ResponseEntity<ProductRequestDto> addNewProductApi(PostAddNewProductDto postAddNewProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductRequestDto> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                postAddNewProductDto,
                ProductRequestDto.class);
        return response;
    }

    public ResponseEntity<ProductRequestDto> updateProductApi(ProductRequestDto productRequestDto, Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        ResponseEntity<ProductRequestDto> response = requestForEntity(
                HttpMethod.PUT,
                "https://fakestoreapi.com/products/{id}",
                productRequestDto,
                ProductRequestDto.class,
                productId
        );
        return response;
    }

    public ResponseEntity<ProductRequestDto> deleteProductApi(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        ResponseEntity<ProductRequestDto> response = requestForEntity(
                HttpMethod.DELETE,
                "https://fakestoreapi.com/products/{id}",
                null,
                ProductRequestDto.class,
                productId
        );
        return response;
    }

    public ResponseEntity<Product> patchProductApi(ProductRequestDto productRequestDto, Long productId){
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        ResponseEntity<Product> response = requestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                productRequestDto,
                Product.class,
                productId
        );
        return response;
    }

    public ResponseEntity<String[]> getAllCategoriesApi() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String[].class
        );
        return response;
    }

    public ResponseEntity<GetProductsByCategoryDto[]> getProductsByCategoryApi(String name) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GetProductsByCategoryDto[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/category/{name}",
                GetProductsByCategoryDto[].class,
                name
        );
        return response;
    }
}
