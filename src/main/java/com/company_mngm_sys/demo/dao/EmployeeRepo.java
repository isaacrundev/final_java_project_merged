package com.company_mngm_sys.demo.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.company_mngm_sys.demo.entity.Employees;

public interface EmployeeRepo extends CrudRepository<Employees, Long> {

    @Override
    public List<Employees> findAll();

    public Employees findByEmployeeId(Integer id);

}
