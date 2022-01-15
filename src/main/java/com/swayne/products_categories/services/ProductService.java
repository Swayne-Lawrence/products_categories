package com.swayne.products_categories.services;

import java.util.ArrayList;
import java.util.List;

import com.swayne.products_categories.models.Category;
import com.swayne.products_categories.models.Product;
import com.swayne.products_categories.repositories.CategoryRepository;
import com.swayne.products_categories.repositories.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    
    
    public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getOne(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public List<Category> getCategory(Product product){
        return categoryRepository.findByProductsNotContains(product);
    }
    public List<Category> remainingCategories(Product product){
        return categoryRepository.findByProductsNotContains(product);
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

}
