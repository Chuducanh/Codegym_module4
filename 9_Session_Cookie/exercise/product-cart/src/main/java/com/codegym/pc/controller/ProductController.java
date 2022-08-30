package com.codegym.pc.controller;

import com.codegym.pc.model.Cart;
import com.codegym.pc.model.Product;
import com.codegym.pc.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/product")
    public ModelAndView listProduct(){
        return new ModelAndView("list", "products", iProductService.findAll());
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProduct(@PathVariable Long id)
    {
        ModelAndView modelAndView = new ModelAndView("view");
        Optional<Product> product = iProductService.findById(id);
        modelAndView.addObject("product", product.get());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/product";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseToCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = iProductService.findById(id);
        cart.decreaseProduct(productOptional.get());
        return "redirect:/cart";
    }

}
