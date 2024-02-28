package com.accountingOffice.zus.controller;


import com.accountingOffice.zus.dao.HealthContributionBaseRepository;
import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.Deduction;
import com.accountingOffice.zus.entity.HealthContributionBase;
import com.accountingOffice.zus.entity.Income;
import com.accountingOffice.zus.service.HealthContributionBaseService;
import com.accountingOffice.zus.service.IncomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/healthContributionBase")
public class HealthContributionBaseController {
    private HealthContributionBaseService healthContributionBaseService;

    public HealthContributionBaseController(HealthContributionBaseService healthContributionBaseService) {
        this.healthContributionBaseService = healthContributionBaseService;
    }

    @GetMapping("/list")
    public String listHealthContributionBase(Model model, Company company) {
        List<HealthContributionBase> healthContributionBases = healthContributionBaseService.findByCompanyId(company);

        model.addAttribute("healthContributionBases", healthContributionBases);
        return "healthContributionBases";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("healthContributionBaseId") long healthContributionBaseId){

        healthContributionBaseService.deleteById(healthContributionBaseId);

        return "redirect:/company/list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        HealthContributionBase healthContributionBase = new HealthContributionBase();

        model.addAttribute("healthContributionBase", healthContributionBase);

        return "base-form";
    }
    @PostMapping("/save")
    public String saveContributionBase(@ModelAttribute("healthContributionBase") HealthContributionBase healthContributionBase, Company company){

        healthContributionBaseService.save(healthContributionBase,company);

        return "redirect:/company/list";
    }
}
