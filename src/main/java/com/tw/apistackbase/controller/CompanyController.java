package com.tw.apistackbase.controller;
import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.tw.apistackbase.model.Company.getTestCompany;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @GetMapping
    public List<Company> getAllCompanys(){
        return getTestCompany();
    }

    @GetMapping("/{id}")
    public Company getSpecificCompany(@PathVariable int id){
        List<Company> companies=getTestCompany();
        for(Company company:companies){
            if(company.getId()==id){
                return company;
            }
        }
        return null;
    }

    @GetMapping("/{id}/employees")
    public  List<Employee>  getSpecCompanyEmployees (@PathVariable int id){
        List<Company> companies=getTestCompany();
        for(Company company:companies){
            if(company.getId()==id){
                return company.getEmployees();
            }
        }
        return null;
    }

    @GetMapping(value = "", params = {"page","pageSize"})
    public List<Company> getPageCompanys (@RequestParam int page, @RequestParam int pageSize){
        List<Company> companies = getTestCompany();
        List<Company> pageList=new ArrayList<>();
        for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
            if (i < companies.size()) {
                pageList.add(companies.get(i));
            }
        }
        return pageList;
    }

    @PostMapping
    public List<Company> addCompany(@RequestBody Company company){
        List<Company> companies=new ArrayList<>();
        companies.add(company);
        return companies;
    }

    @PutMapping
    public List<Company> updateCompany(@RequestBody Company company){
        List<Company> companies=getTestCompany();
        for(Company currentCompany:companies){
            if(currentCompany.getId()==company.getId()){
                companies.remove(currentCompany);
                companies.add(company);
                break;
            }
        }
        return companies;
    }
    @DeleteMapping("/{id}")
    public List<Company> deleteCompany(@PathVariable int id){
        List<Company> companies=getTestCompany();
        for(Company currentCompany:companies){
            if(currentCompany.getId()==id){
                companies.remove(currentCompany);
                break;
            }
        }
        return companies;
    }
}
