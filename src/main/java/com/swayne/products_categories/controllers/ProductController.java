package com.swayne.products_categories.controllers;

import javax.validation.Valid;

import com.swayne.products_categories.models.CP;
import com.swayne.products_categories.models.Product;
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
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final CPService cpService;

    public ProductController(ProductService productService, CategoryService categoryService,CPService cpService){
        this.productService=productService;
        this.categoryService= categoryService;
        this.cpService=cpService;
    }

    @GetMapping("/")
    public String home(@ModelAttribute("product") Product product){
        return "/product/index.jsp";
    }

    @PostMapping("/form")
    public String form(@Valid @ModelAttribute("product") Product product, BindingResult result){
        if(result.hasErrors()){
            return "/product/index.jsp";
        }
        productService.create(product);

        return "redirect:/";
    }

    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("products", productService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        return "/product/show.jsp";
    }

    @GetMapping("/show/{id}")
    public String product_show(@PathVariable("id") Long id,Model model,@ModelAttribute("cp") CP cp){
        Product pro=productService.getOne(id);
        model.addAttribute("product", productService.getOne(id));
        model.addAttribute("categories", productService.remainingCategories(pro));
        return "/product/product_show.jsp";
    }

    @PostMapping("/category_selection")
    public String category_selection(@Valid @ModelAttribute("cp") CP cp,BindingResult result,Model model){
        if(result.hasErrors()){
            Product pro=productService.getOne(cp.getProduct().getId());
            model.addAttribute("product", productService.getOne(cp.getProduct().getId()));
            model.addAttribute("categories", productService.remainingCategories(pro));
            return "/product/product_show.jsp";
        }
        cpService.create(cp);
        return "redirect:/show";
    }

}
