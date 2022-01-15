package com.swayne.products_categories.services;

import com.swayne.products_categories.models.CP;
import com.swayne.products_categories.repositories.CPRepository;

import org.springframework.stereotype.Service;

@Service
public class CPService {
    private final CPRepository cpRepository;

    public CPService(CPRepository cpRepository){
        this.cpRepository=cpRepository;
    }

    public CP create(CP cp){
        return cpRepository.save(cp);
    }
}
