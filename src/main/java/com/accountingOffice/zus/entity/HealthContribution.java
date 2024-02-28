package com.accountingOffice.zus.entity;

import jakarta.persistence.*;

@Entity
@Table
public class HealthContribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long healthContributionId;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyId;
    private int month;

    private double healthContributionBase;
    private double healthContributionAmount;

    public HealthContribution() {
    }

    public HealthContribution(Company companyId, int month, double healthContributionBase, double healthContributionAmount) {
        this.companyId = companyId;
        this.month = month;
        this.healthContributionBase = healthContributionBase;
        this.healthContributionAmount = healthContributionAmount;
    }

    public long getHealthContributionId() {
        return healthContributionId;
    }

    public void setHealthContributionId(long healthContributionId) {
        this.healthContributionId = healthContributionId;
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

    public double getHealthContributionBase() {
        return healthContributionBase;
    }

    public void setHealthContributionBase(double healthContributionBase) {
        this.healthContributionBase = healthContributionBase;
    }

    public double getHealthContributionAmount() {
        return healthContributionAmount;
    }

    public void setHealthContributionAmount(double healthContributionAmount) {
        this.healthContributionAmount = healthContributionAmount;
    }

    @Override
    public String toString() {
        return "HealthContribution{" +
                "healthContributionId=" + healthContributionId +
                ", companyId=" + companyId +
                ", month=" + month +
                ", healthContributionBase=" + healthContributionBase +
                ", healthContributionAmount=" + healthContributionAmount +
                '}';
    }
}
