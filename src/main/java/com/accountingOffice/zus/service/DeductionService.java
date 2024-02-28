package com.accountingOffice.zus.service;

import com.accountingOffice.zus.dao.DeductionRepository;
import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.Deduction;
import com.accountingOffice.zus.entity.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeductionService implements Services{
    private DeductionRepository deductionRepository;
    @Autowired
    public DeductionService(DeductionRepository deductionRepository) {
        this.deductionRepository = deductionRepository;
    }

    @Override
    public Deduction findById(long deductionId) {
        Optional<Deduction> result =deductionRepository.findById(deductionId);

        Deduction deduction = new Deduction();

        if(result.isPresent()){
            deduction = result.get();
        }
        else{
            throw new RuntimeException("Did not find deduction id - " + deductionId);
        }

        return deduction;
    }

    @Override
    public List<Deduction> findAll() {
        return deductionRepository.findAll();
    }

    public Deduction save(Deduction deduction) {
        return deductionRepository.save(deduction);
    }

    @Override
    public void deleteById(long deductionId) {
        deductionRepository.deleteById(deductionId);

    }
    public List<Deduction> findByCompanyId(Company company){
        return deductionRepository.findByCompanyId(company);
    }
    public Deduction findByCompanyIdAndPaymentMonth(Company company, int paymentMonth) {
        List<Deduction> deductions = deductionRepository.findByCompanyIdAndPaymentMonth(company, paymentMonth);
        if (!deductions.isEmpty()) {
            return deductions.get(0);
        } else {
            return null;
        }
    }
    public double getTotalSocialContributionAmountForCompany(Company company) {
        List<Deduction> deductions = deductionRepository.findByCompanyId(company);
        double totalSocialContributionAmount = 0.0;
        for (Deduction deduction : deductions) {
            totalSocialContributionAmount += deduction.getSocialContributionAmount();
        }
        return totalSocialContributionAmount;
    }

}
