package com.accountingOffice.zus.entity;

import jakarta.persistence.*;

@Entity
@Table
public class HealthContributionBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int healthContributionBaseId;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyId;
    private int month;

    private double income;

    private double socialContributionAmount;
    private double healthContributionBase;

    public HealthContributionBase() {
    }

    public HealthContributionBase(Company companyId, int month, double income, double socialContributionAmount, double healthContributionBase) {
        this.companyId = companyId;
        this.month = month;
        this.income = income;
        this.socialContributionAmount = socialContributionAmount;
        this.healthContributionBase = healthContributionBase;
    }

    @Override
    public String toString() {
        return "HealthContributionBase{" +
                "healthContributionBaseId=" + healthContributionBaseId +
                ", companyId=" + companyId +
                ", month=" + month +
                ", income=" + income +
                ", socialContributionAmount=" + socialContributionAmount +
                ", healthContributionBase=" + healthContributionBase +
                '}';
    }

    public int getHealthContributionBaseId() {
        return healthContributionBaseId;
    }

    public void setHealthContributionBaseId(int healthContributionBaseId) {
        this.healthContributionBaseId = healthContributionBaseId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getSocialContributionAmount() {
        return socialContributionAmount;
    }

    public void setSocialContributionAmount(double socialContributionAmount) {
        this.socialContributionAmount = socialContributionAmount;
    }

    public double getHealthContributionBase() {
        return healthContributionBase;
    }

    public void setHealthContributionBase(double healthContributionBase) {
        this.healthContributionBase = healthContributionBase;
    }
}
