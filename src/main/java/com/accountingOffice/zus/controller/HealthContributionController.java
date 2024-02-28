package com.accountingOffice.zus.controller;


import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.HealthContribution;
import com.accountingOffice.zus.entity.HealthContributionBase;
import com.accountingOffice.zus.service.HealthContributionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/healthContribution")
public class HealthContributionController {
    private HealthContributionService healthContributionService;

    public HealthContributionController(HealthContributionService healthContributionService) {
        this.healthContributionService = healthContributionService;
    }

    @GetMapping("/list")
    public String listhealthContribution(Model model, Company company) {
        List<HealthContribution> healthContribution = healthContributionService.findByCompanyId(company);

        model.addAttribute("healthContribution", healthContribution);
        return "healthContribution";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("healthContributionId") long healthContributionId){

        healthContributionService.deleteById(healthContributionId);

        return "redirect:/company/list";
    }
    @PostMapping("/save")
    public String saveContribution(@ModelAttribute("healthContribution") HealthContribution healthContribution, Company company){

        healthContributionService.save(healthContribution,company);

        return "redirect:/company/list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        HealthContribution healthContribution = new HealthContribution();

        model.addAttribute("healthContribution", healthContribution);

        return "contribution-form";
    }

}
