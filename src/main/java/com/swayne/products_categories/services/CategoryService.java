package com.swayne.products_categories.services;

import java.util.List;

import com.swayne.products_categories.models.Category;
import com.swayne.products_categories.models.Product;
import com.swayne.products_categories.repositories.CategoryRepository;
import com.swayne.products_categories.repositories.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class CategoryService  {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository){
        this.categoryRepository=categoryRepository;
        this.productRepository=productRepository;
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
    public List<Product> getProducts(Category category){
        return productRepository.findAllByCategories(category);
    }
    public List<Product> remainingProducts(Category category){
        return productRepository.findByCategoriesNotContains(category);
    }

    public Category getOne(Long id){
        return categoryRepository.findById(id).orElse(null);
    }
    public Category create(Category c){
        return categoryRepository.save(c);
    }

}
