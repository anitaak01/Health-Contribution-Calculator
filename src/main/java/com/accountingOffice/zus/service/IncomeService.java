package com.accountingOffice.zus.service;

import com.accountingOffice.zus.dao.IncomeRepository;
import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.Deduction;
import com.accountingOffice.zus.entity.Income;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeService implements Services {
    private IncomeRepository incomeRepository;

    @Autowired
    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public Income findById(long id) {
        Optional<Income> result = incomeRepository.findById(id);

        Income income = new Income();

        if (result.isPresent()) {
            income = result.get();
        } else {
            throw new RuntimeException("Did not find income id - " + id);
        }

        return income;
    }

    @Override
    public List<Income> findAll() {
        return incomeRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        incomeRepository.deleteById(id);
    }

    public Income save(Income income) {
        return incomeRepository.save(income);

    }

    public List<Income> findByCompanyId(Company company) {
        return incomeRepository.findByCompanyId(company);
    }

    public double getTotalIncomeForCompany(Company company) {
        List<Income> incomes = incomeRepository.findByCompanyId(company);
        double totalIncome = 0.0;
        for (Income income : incomes) {
            totalIncome += income.getIncome();
        }
        return totalIncome;
    }
    public Income findByMonthAndCompanyId(int month, Company company) {
        List<Income> incomeByCompanyId = findByCompanyId(company);
        for (Income income : incomeByCompanyId) {
            if (income.getMonth() == month) {
                return income;
            }
        }
        return null;
    }
}
