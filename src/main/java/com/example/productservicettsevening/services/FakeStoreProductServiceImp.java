package com.example.productservicettsevening.services;

import com.example.productservicettsevening.Clients.FakeStoreClient;
import com.example.productservicettsevening.dtos.PostAddNewProductDto;
import com.example.productservicettsevening.dtos.ProductRequestDto;
import com.example.productservicettsevening.models.Category;
import com.example.productservicettsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImp implements ProductService{

    private FakeStoreClient fakeStoreClient;
    public FakeStoreProductServiceImp(FakeStoreClient fakeStoreClient){
        this.fakeStoreClient = fakeStoreClient;
    }
    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<ProductRequestDto[]> response = fakeStoreClient.getAllProductsApi();
        List<Product> answer = new ArrayList<>();
        for(ProductRequestDto obj: response.getBody()){
            ProductRequestDto productRequestDto = obj;
            Product product = new Product();
            product.setId(productRequestDto.getId());
            product.setTitle(productRequestDto.getTitle());
            product.setPrice(productRequestDto.getPrice());
            product.setDescription(productRequestDto.getDescription());
            Category category = new Category();
            category.setName(productRequestDto.getCategory());
            product.setCategory(category);
            answer.add(product);
        }
        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        ResponseEntity<ProductRequestDto> response = fakeStoreClient.getSingleProductApi(productId);
        ProductRequestDto productRequestDto = response.getBody();
        Product product = new Product();
        product.setId(productRequestDto.getId());
        product.setTitle(productRequestDto.getTitle());
        product.setPrice(productRequestDto.getPrice());
        product.setDescription(productRequestDto.getDescription());
        Category category = new Category();
        category.setName(productRequestDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public PostAddNewProductDto addNewProduct(PostAddNewProductDto postAddNewProductDto) {
        ResponseEntity<ProductRequestDto> response = fakeStoreClient.addNewProductApi(postAddNewProductDto);
        ProductRequestDto productRequestDto = response.getBody();

        PostAddNewProductDto product1 = new PostAddNewProductDto();
        product1.setTitle(productRequestDto.getTitle());
        product1.setPrice(productRequestDto.getPrice());
        product1.setImage(productRequestDto.getImage());
        product1.setDescription(productRequestDto.getDescription());
        product1.setCategory(productRequestDto.getCategory());
        return product1;
    }

    @Override
    public Product updateProduct(ProductRequestDto productRequestDto, Long productId) {
        ResponseEntity<ProductRequestDto> response = fakeStoreClient.updateProductApi(productRequestDto,productId);
        ProductRequestDto productRequestDto1 = response.getBody();
        Product product = new Product();
        product.setId(productRequestDto1.getId());
        product.setTitle(productRequestDto1.getTitle());
        product.setPrice(productRequestDto1.getPrice());
        product.setDescription(productRequestDto1.getDescription());
        Category category = new Category();
        category.setName(productRequestDto1.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product deleteProduct(Long productId) {
        ResponseEntity<ProductRequestDto> response = fakeStoreClient.deleteProductApi(productId);
        ProductRequestDto productRequestDto = response.getBody();
        Product product = new Product();
        product.setId(productRequestDto.getId());
        product.setTitle(productRequestDto.getTitle());
        product.setPrice(productRequestDto.getPrice());
        product.setDescription(productRequestDto.getDescription());
        Category category = new Category();
        category.setName(productRequestDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product patchProduct(ProductRequestDto productRequestDto, Long productId){
        ResponseEntity<Product> response = fakeStoreClient.patchProductApi(productRequestDto,productId);
        Product product = response.getBody();
        return product;
    }
}
