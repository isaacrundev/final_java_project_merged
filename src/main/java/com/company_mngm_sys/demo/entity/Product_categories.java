package com.company_mngm_sys.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Product_categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int categoryId;

    @Column(name ="name")
    private String categoryName;



    public Product_categories() {
    }

    public Product_categories(int productCategoryId, String categoryName) {
        this.categoryId = productCategoryId;
        this.categoryName = categoryName;

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


   }
