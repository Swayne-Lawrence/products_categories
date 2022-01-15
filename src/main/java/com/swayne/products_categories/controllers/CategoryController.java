package com.swayne.products_categories.controllers;

import javax.validation.Valid;

import com.swayne.products_categories.models.CP;
import com.swayne.products_categories.models.Category;
import com.swayne.products_categories.services.CPService;
import com.swayne.products_categories.services.CategoryService;
import com.swayne.products_categories.services.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final CPService cpService;

    public CategoryController( CategoryService categoryService, ProductService productService, CPService cpService){
        this.categoryService=categoryService;
        this.productService=productService;
        this.cpService=cpService;
    }

    @GetMapping("/create_category")
    public String create_category(@ModelAttribute("category") Category category){
        return "/category/create_category.jsp";

    }

    @PostMapping("/category_form")
    public String category_form(@Valid @ModelAttribute("category") Category category, BindingResult result){
        if(result.hasErrors()){
            return "/category/create_category.jsp";
        }
        categoryService.create(category);
        return "redirect:/create_category";
    }

    @GetMapping("/items/{id}")
    public String product_show(@PathVariable("id") Long id,Model model,@ModelAttribute("cp") CP cp){
        Category cat=categoryService.getOne(id);
        model.addAttribute("category", categoryService.getOne(id));
        model.addAttribute("products", categoryService.remainingProducts(cat));
        return "/category/item.jsp";
    }

    @PostMapping("/product_selection")
    public String category_selection(@Valid @ModelAttribute("cp") CP cp,BindingResult result,Model model){
        if(result.hasErrors()){
            Category cat=categoryService.getOne(cp.getCategory().getId());
            model.addAttribute("category", cat);
            model.addAttribute("products", categoryService.remainingProducts(cat));
            return "/category/item.jsp";
        }
        cpService.create(cp);
        return "redirect:/show";
    }

}
