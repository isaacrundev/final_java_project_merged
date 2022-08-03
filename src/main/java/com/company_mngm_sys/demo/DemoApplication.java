package com.company_mngm_sys.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//don't change

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company_mngm_sys.demo.dao.EmployeeRepo;
import com.company_mngm_sys.demo.entity.Employees;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepo empRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// sample data
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employees em1 = new Employees("fullName", 12071995);
		empRepo.save(em1);
		
	}

}
