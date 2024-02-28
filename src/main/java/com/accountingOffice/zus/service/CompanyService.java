package com.accountingOffice.zus.service;

import com.accountingOffice.zus.dao.CompanyRepository;
import com.accountingOffice.zus.dao.DeductionRepository;
import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.Deduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements Services{
    private CompanyRepository companyRepository;
    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company findById(long companyId) {
        Optional<Company> result =companyRepository.findById(companyId);

        Company company = null;

        if(result.isPresent()){
            company = result.get();
        }
        else{
            throw new RuntimeException("Did not find company id - " + companyId);
        }

        return company;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteById(long companyId) {
        companyRepository.deleteById(companyId);

    }
}
