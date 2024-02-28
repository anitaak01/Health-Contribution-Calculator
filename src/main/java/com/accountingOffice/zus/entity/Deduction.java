package com.accountingOffice.zus.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Income_deduction")
public class Deduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deductionId;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyId;
    private int paymentMonth;
    private double socialContributionAmount;
    private double totalSocialContributionAmount;

    @Override
    public String toString() {
        return "Deduction{" +
                "deductionId=" + deductionId +
                ", companyId=" + companyId +
                ", paymentMonth=" + paymentMonth +
                ", socialContributionAmount=" + socialContributionAmount +
                ", totalSocialContributionAmount=" + totalSocialContributionAmount +
                '}';
    }

    public double getTotalSocialContributionAmount() {
        return totalSocialContributionAmount;
    }

    public void setTotalSocialContributionAmount(double totalSocialContributionAmount) {
        this.totalSocialContributionAmount = totalSocialContributionAmount;
    }

    public Deduction() {
    }

    public Deduction(Company companyId, int paymentMonth, double socialContributionAmount, double totalSocialContributionAmount) {
        this.companyId = companyId;
        this.paymentMonth = paymentMonth;
        this.socialContributionAmount = socialContributionAmount;
        this.totalSocialContributionAmount = totalSocialContributionAmount;
    }

    public long getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(long deductionId) {
        this.deductionId = deductionId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public int getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(int paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public double getSocialContributionAmount() {
        return socialContributionAmount;
    }

    public void setSocialContributionAmount(double socialContributionAmount) {
        this.socialContributionAmount = socialContributionAmount;
    }

}

