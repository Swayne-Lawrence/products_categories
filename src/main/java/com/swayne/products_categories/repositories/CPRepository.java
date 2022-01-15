package com.swayne.products_categories.repositories;

import com.swayne.products_categories.models.CP;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CPRepository extends CrudRepository<CP,Long> {

}
