package com.accountingOffice.zus.controller;


import com.accountingOffice.zus.entity.Company;

import com.accountingOffice.zus.entity.Income;
import com.accountingOffice.zus.service.CompanyService;
import com.accountingOffice.zus.service.IncomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/income")
public class IncomeController {
    private IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/list")
    public String listIncome(Model model, Company company) {
        List<Income> income = incomeService.findByCompanyId(company);

        model.addAttribute("income", income);
        return "income";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model, Company company){
        Income income = new Income();

        model.addAttribute("income", income);

        return "income-form";
    }
    @PostMapping("/save")
    public String saveIncome(@ModelAttribute("income")Income income,@ModelAttribute("company")Company company){
        double incomes = income.getRevenue() - income.getCost();
        income.setIncome(incomes);
        incomeService.save(income);

        double totalIncome = incomeService.getTotalIncomeForCompany(company);

        income.setTotalIncome(totalIncome);
        incomeService.save(income);

        return "redirect:/company/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id")long id, Model model){

        Income income = incomeService.findById(id);

        model.addAttribute("income",income);

        return "income-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id){

        incomeService.deleteById(id);

        return "redirect:/company/list";
    }

}
