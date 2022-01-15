package com.swayne.products_categories.repositories;

import java.util.List;

import com.swayne.products_categories.models.Category;
import com.swayne.products_categories.models.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{
    List<Category> findAll();
    List<Category> findAllByProducts(Product product);
    List<Category> findByProductsNotContains(Product product);
}
