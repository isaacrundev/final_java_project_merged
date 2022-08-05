//employee controleer

package com.company_mngm_sys.demo.web;

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
import com.company_mngm_sys.demo.entity.Employees;

@Controller // employeeをaddする用のクラス
@RequestMapping("/employees") // URLとコントローラーのクラスまたはメソッドを紐づけることができるアノテーション
// employeeの下に下記の表示されます(request by default)

public class EmployeesController {

    @Autowired
    EmployeeRepo repo;

    // @Autowired
    // EmployeeRepo empRepo;

    @GetMapping // lists
    public String displayEmployees(Model model) {
        List<Employees> employees = repo.findAll();
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        model.addAttribute("employees", new Employees());
        return "employees/new-employees";
    }

    // I'm gonna redirect to this page after adding
    @PostMapping("/save")
    public String createEmployees(Employees employees) {
        // product.setProductId(0);??
        repo.save(employees);
        return "redirect:/employees"; // コロンはリクエストを返す
    }

    @GetMapping("/edit/{id}")
    public String editClient(Model model, @PathVariable("id") Long id) {
        model.addAttribute("employees", repo.findByEmployeeId(id));
        return "employees/edit-employees";
    }

    @PostMapping("/edit_save/{id}")
    public String editSaveEmployees(Employees Employees,
            @PathVariable("id") Long id) {
        Employees.setEmployeeId(id);
        System.out.println(Employees.getEmployeeId());
        repo.save(Employees);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(Model model, @PathVariable("id") Long id) {
        Employees employee = repo.findByEmployeeId(id);
        repo.delete(employee);

        return "redirect:/employees";
    }

}
