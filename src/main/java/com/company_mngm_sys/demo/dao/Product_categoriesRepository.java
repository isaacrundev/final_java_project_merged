
package com.company_mngm_sys.demo.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.company_mngm_sys.demo.entity.Product_categories;


@Repository
public interface Product_categoriesRepository extends CrudRepository <Product_categories, Integer>{
    
    @Override
    public List<Product_categories> findAll();   

}
