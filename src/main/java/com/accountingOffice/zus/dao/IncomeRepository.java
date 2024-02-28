package com.accountingOffice.zus.dao;


import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.Deduction;
import com.accountingOffice.zus.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Long>{
    List<Income> findByCompanyId(Company company);
    @Query("SELECT SUM(i.income) FROM Income i WHERE i.companyId = :companyId")
    double getTotalIncomeForCompany(@Param("company") Company company);

    Income findByMonthAndCompanyId(int month, Company company);

    List<Income> findByCompanyIdAndMonth(Company company, int month);
}


