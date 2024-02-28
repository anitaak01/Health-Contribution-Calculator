package com.accountingOffice.zus.dao;


import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.Deduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DeductionRepository extends JpaRepository<Deduction, Long> {
    List<Deduction> findByCompanyId(Company company);
    Deduction findByPaymentMonth(int paymentMonth);
    List<Deduction> findByCompanyIdAndPaymentMonth(Company company, int paymentMonth);
    @Query("SELECT SUM(d.socialContributionAmount) FROM Deduction d WHERE d.companyId = :companyId")
    double getTotalSocialContributionAmountForCompany(@Param("company") Company company);


}
