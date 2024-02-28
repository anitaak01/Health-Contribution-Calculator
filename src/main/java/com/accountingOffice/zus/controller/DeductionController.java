package com.accountingOffice.zus.controller;


import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.Deduction;
import com.accountingOffice.zus.service.DeductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deduction")
public class DeductionController {
    private DeductionService deductionService;

    public DeductionController(DeductionService deductionService) {
        this.deductionService = deductionService;
    }
    @GetMapping("/list")
    public String listDeductionsByCompanyId(Model model, Company company) {
        List<Deduction> deductions = deductionService.findByCompanyId(company);

        model.addAttribute("deductions", deductions);
        return "deductions";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Deduction deduction = new Deduction();

        model.addAttribute("deductions", deduction);

        return "deduction-form";
    }
    @PostMapping("/save")
    public String saveDeduction(@ModelAttribute("deductions")Deduction deduction, @ModelAttribute("company")Company company){
        deductionService.save(deduction);

        double totalSocialContributionAmount = deductionService.getTotalSocialContributionAmountForCompany(company);
        deduction.setTotalSocialContributionAmount(totalSocialContributionAmount);
        deductionService.save(deduction);

        return "redirect:/company/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("deductionId")long deductionId, Model model){

        Deduction deduction = deductionService.findById(deductionId);

        model.addAttribute("deductions",deduction);

        return "deduction-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("deductionId") long deductionId){

        deductionService.deleteById(deductionId);

        return "redirect:/company/list";
    }

}
