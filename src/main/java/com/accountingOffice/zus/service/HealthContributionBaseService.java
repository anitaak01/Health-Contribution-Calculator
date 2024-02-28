package com.accountingOffice.zus.service;

import com.accountingOffice.zus.dao.DeductionRepository;
import com.accountingOffice.zus.dao.HealthContributionBaseRepository;
import com.accountingOffice.zus.dao.IncomeRepository;
import com.accountingOffice.zus.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthContributionBaseService implements Services{
    private HealthContributionBaseRepository healthContributionBaseRepository;
    private DeductionRepository deductionRepository;
    private IncomeRepository incomeRepository;

    @Autowired
    public HealthContributionBaseService(HealthContributionBaseRepository healthContributionBaseRepository, DeductionRepository deductionRepository, IncomeRepository incomeRepository) {
        this.healthContributionBaseRepository = healthContributionBaseRepository;
        this.deductionRepository = deductionRepository;
        this.incomeRepository = incomeRepository;
    }

    @Override
    public HealthContributionBase findById(long healthContributionBaseId) {
        Optional<HealthContributionBase> result =healthContributionBaseRepository.findById(healthContributionBaseId);

        HealthContributionBase healthContributionBase = new HealthContributionBase();

        if(result.isPresent()){
            healthContributionBase = result.get();
        }
        else{
            throw new RuntimeException("Did not find health contribution base id - " + healthContributionBaseId);
        }

        return healthContributionBase;
    }

    @Override
    public List<HealthContributionBase> findAll() {
        return healthContributionBaseRepository.findAll();
    }

    @Override
    public void deleteById(long healthContributionBaseId) {
        healthContributionBaseRepository.deleteById(healthContributionBaseId);
    }

    public HealthContributionBase save(HealthContributionBase healthContributionBase, Company company){
        List<Deduction> deductions = deductionRepository.findByCompanyIdAndPaymentMonth(company, healthContributionBase.getMonth());
        double totalDeduction =0;
        if (!deductions.isEmpty()) {
            Deduction deduction = deductions.get(0);
            healthContributionBase.setSocialContributionAmount(deduction.getSocialContributionAmount());
             totalDeduction = deduction.getTotalSocialContributionAmount();
        } else {
            return null;
        }

        Income income = incomeRepository.findByMonthAndCompanyId(healthContributionBase.getMonth(), company);

            if(income.getTotalIncome() > income.getIncome()){
                healthContributionBase.setIncome(income.getIncome());

            } else {
                healthContributionBase.setIncome(income.getTotalIncome()- totalDeduction + healthContributionBase.getSocialContributionAmount());

            }
        healthContributionBase.setHealthContributionBase(healthContributionBase.getIncome() - healthContributionBase.getSocialContributionAmount());

        return healthContributionBaseRepository.save(healthContributionBase);
    }
    public List<HealthContributionBase> findByCompanyId(Company company){
        return healthContributionBaseRepository.findByCompanyId(company);
    }
    public List<HealthContributionBase> findByCompanyIdAndMonth(Company company, int month){
        return findByCompanyIdAndMonth(company, month);
    }




}