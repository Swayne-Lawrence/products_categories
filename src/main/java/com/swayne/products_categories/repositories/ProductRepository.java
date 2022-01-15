package com.swayne.products_categories.repositories;

import java.util.List;

import com.swayne.products_categories.models.Category;
import com.swayne.products_categories.models.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
    List<Product> findAll();
    List<Product> findAllByCategories(Category category);
    List<Product> findByCategoriesNotContains(Category category);

}
