package com.learn.controller;

import com.learn.controller.dto.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
@Slf4j
public class ProductController {

    @GetMapping("/add")
    public String addProductForm(Model model){
        List<String> categories = new ArrayList<>();
        categories.add("Cloths");
        categories.add("Mobiles");
        categories.add("Toys");
        model.addAttribute("product" , new Product());
        model.addAttribute("categories" , categories);
        log.info("Message coming from save :: {}" , model.getAttribute("successMessage"));
        return "addProductForm";
    }

    @PostMapping("/save")
    public RedirectView saveProduct(@ModelAttribute("product") Product product,
                                    Model model , RedirectAttributes redirect){
        log.info("Product name :: {}" , product.getName());
        log.info("Product price :: {}" , product.getPrice());
        log.info("Is prime product :: {}" , product.getIsPrimeProduct());
        log.info("Product category :: {}" , product.getCategory());
        // Redirecting along with model attribute passing
        RedirectView redirectView = new RedirectView("/product/add");
        redirect.addFlashAttribute("successMessage" , "Product added successfully....");
        return redirectView;
    }

}