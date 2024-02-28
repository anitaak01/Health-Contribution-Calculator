package com.accountingOffice.zus.dao;

import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.HealthContribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HealthContributionRepository extends JpaRepository<HealthContribution, Long> {
    List<HealthContribution> findByCompanyId(Company company);
}
