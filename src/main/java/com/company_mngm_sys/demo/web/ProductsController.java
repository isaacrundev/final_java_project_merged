package com.company_mngm_sys.demo.web;

import java.text.Normalizer.Form;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company_mngm_sys.demo.dao.EmployeeRepo;
import com.company_mngm_sys.demo.dao.Product_categoriesRepository;
import com.company_mngm_sys.demo.dao.ProductsRepository;
import com.company_mngm_sys.demo.dto.ProductCategoryEmp;
import com.company_mngm_sys.demo.entity.Employees;
import com.company_mngm_sys.demo.entity.Product_categories;
import com.company_mngm_sys.demo.entity.Products;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsRepository productRepo;

    @Autowired
    Product_categoriesRepository product_categoriesRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping
    public String displayProducts(Model model) {

        List<ProductCategoryEmp> products = productRepo.productsWithNames();
        model.addAttribute("products", products);

        return "products/list_products";

    }

    @GetMapping("/new")
    public String displayProductForm(Model model) {
        model.addAttribute("anything", new Products());

        List<Product_categories> product_categories = product_categoriesRepo.findAll();
		model.addAttribute("product_categories", product_categories);

        List<Employees> employees = employeeRepo.findAll();
		model.addAttribute("employees", employees);

        return "products/new_product";
    }

    @PostMapping("/save")
    public String createProduct(Products product, @RequestParam int categoryId, @RequestParam int employeeId) {
        product.setProductId(0);
        product.setProductCategoryId(categoryId);
        product.setProductEmployeeId(employeeId);
        
        productRepo.save(product);
        return "redirect:/products";
    }
    @PostMapping("/edit_save/{id}")
    public String editSaveProduct(Products product, @RequestParam int categoryId, @RequestParam int employeeId,  @PathVariable("id") Integer id) {
        product.setProductId(id);
        System.out.println(product.getProductId());
        product.setProductCategoryId(categoryId);
        product.setProductEmployeeId(employeeId);
        
        productRepo.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("anything", productRepo.findByProductId(id));

        List<Product_categories> product_categories = product_categoriesRepo.findAll();
		model.addAttribute("product_categories", product_categories);

        List<Employees> employees = employeeRepo.findAll();
		model.addAttribute("employees", employees);

        return "products/edit_product";
 
    }
    @GetMapping("/delete/{id}")
    public String createEmployee(Model model, @PathVariable("id") Integer id) {
        Products product = productRepo.findByProductId(id);
        productRepo.delete(product);

        return "redirect:/products";
    }
}
