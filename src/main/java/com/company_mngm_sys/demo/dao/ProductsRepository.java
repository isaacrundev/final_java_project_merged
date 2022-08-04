
package com.company_mngm_sys.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company_mngm_sys.demo.dto.ProductCategoryEmp;
import com.company_mngm_sys.demo.entity.Products;

@Repository
public interface ProductsRepository extends CrudRepository <Products, Integer>{
    
    
    @Override
    public List<Products> findAll();   

    public Products findByProductId(int id);


    @Query(nativeQuery = true, value = "SELECT pro.id as productId, pro.name as productName, pro.price as productPrice, pro.category_id as category_id, pro.employee_id as employee_id, pc.name as categoryName, e.full_name as fullName "
    + "FROM products pro LEFT JOIN product_categories pc ON pro.category_id = pc.id "
    + "LEFT JOIN employees e ON pro.employee_id = e.employee_id "
    + "ORDER BY pro.id ASC")
    public List<ProductCategoryEmp> productsWithNames();

}
