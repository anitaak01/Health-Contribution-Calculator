package com.accountingOffice.zus.service;

import com.accountingOffice.zus.dao.HealthContributionBaseRepository;
import com.accountingOffice.zus.dao.HealthContributionRepository;
import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.HealthContribution;
import com.accountingOffice.zus.entity.HealthContributionBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthContributionService implements Services{
    private HealthContributionRepository healthContributionRepository;
    private HealthContributionBaseRepository healthContributionBaseRepository;

    @Autowired
    public HealthContributionService(HealthContributionRepository healthContributionRepository, HealthContributionBaseRepository healthContributionBaseRepository) {
        this.healthContributionRepository = healthContributionRepository;
        this.healthContributionBaseRepository = healthContributionBaseRepository;
    }


    @Override
    public HealthContribution findById(long healthContributionId) {
        Optional<HealthContribution> result =healthContributionRepository.findById(healthContributionId);

        HealthContribution healthContribution = new HealthContribution();

        if(result.isPresent()){
            healthContribution = result.get();
        }
        else{
            throw new RuntimeException("Did not find health contribution id - " + healthContributionId);
        }

        return healthContribution;
    }

    @Override
    public List<HealthContribution> findAll() {
        return healthContributionRepository.findAll();
    }

    @Override
    public void deleteById(long healthContributionId) {
        healthContributionRepository.deleteById(healthContributionId);
    }

    public HealthContribution save(HealthContribution healthContribution, Company company){
        List <HealthContributionBase> base = healthContributionBaseRepository.findByCompanyIdAndMonth(company, healthContribution.getMonth());
        HealthContributionBase healthContributionBase = base.get(0);

        healthContribution.setHealthContributionBase(healthContributionBase.getHealthContributionBase());
        double healthContributionAmount;
        if(healthContribution.getHealthContributionBase() * 0.09 > 4242 * 0.09){
            healthContributionAmount = healthContribution.getHealthContributionBase() * 0.09;
        } else{
            healthContributionAmount = 4242 * 0.09;
        }
        healthContribution.setHealthContributionAmount(healthContributionAmount);
        return healthContributionRepository.save(healthContribution);

    }
    public List<HealthContribution> findByCompanyId(Company company){
        return healthContributionRepository.findByCompanyId(company);
    }



}
