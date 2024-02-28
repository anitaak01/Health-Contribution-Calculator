package com.accountingOffice.zus.dao;


import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.Deduction;
import com.accountingOffice.zus.entity.HealthContributionBase;
import com.accountingOffice.zus.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HealthContributionBaseRepository extends JpaRepository<HealthContributionBase, Long> {
    List<HealthContributionBase> findByCompanyId(Company company);
    List<HealthContributionBase> findByCompanyIdAndMonth(Company company, int month);

}
