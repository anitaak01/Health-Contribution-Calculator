package com.accountingOffice.zus.controller;

import com.accountingOffice.zus.entity.Company;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.accountingOffice.zus.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping("/list")
    public String listCompanies(Model model){
        List<Company> companies = companyService.findAll();

        model.addAttribute("companies", companies);
        return "companies";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Company company = new Company();

        model.addAttribute("companies", company);

        return "company-form";
    }
    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("companies")Company company){
        companyService.save(company);

        return "redirect:/company/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("companyId")long companyId, Model model){

        Company company = companyService.findById(companyId);

        model.addAttribute("companies",company);

        return "company-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("companyId") long companyId){

        companyService.deleteById(companyId);

        return "redirect:/company/list";
    }

}
