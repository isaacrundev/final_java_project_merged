package com.company_mngm_sys.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;


@Entity

public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int productId;

    @Column(name ="name")
    private String productName;

    @Column(name ="price")
    private int productPrice;

    @Column(name ="category_id")
    private int productCategoryId;

    @Column(name ="employee_id")
    private int productEmployeeId;


    @ManyToOne
    @JoinColumn(name="employee_id", referencedColumnName="employeeId", insertable = false, updatable = false)
    private Employees employees;
    
    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName="id", insertable = false, updatable = false)
    private Product_categories productCategories;


    public Products() {
    }

    public Products(int productId, String productName, int productPrice, int productCategoryId, int productEmployeeId,
            String categoryName, String picName) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategoryId = productCategoryId;
        this.productEmployeeId = productEmployeeId;
    
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public int getProductEmployeeId() {
        return productEmployeeId;
    }

    public void setProductEmployeeId(int productEmployeeId) {
        this.productEmployeeId = productEmployeeId;
    }



}
