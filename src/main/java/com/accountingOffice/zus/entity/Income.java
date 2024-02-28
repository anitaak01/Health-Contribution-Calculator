package com.accountingOffice.zus.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Income_statement")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyId;
    private int month;
    private double revenue;
    private double cost;

    private double income;
    private double totalIncome;

    public Income() {
    }

    public Income(Company companyId, int month, double revenue, double cost, double income, double totalIncome) {
        this.companyId = companyId;
        this.month = month;
        this.revenue = revenue;
        this.cost = cost;
        this.income = income;
        this.totalIncome = totalIncome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public void setIncome(double income) {
        this.income = income;;
    }
    public double getIncome() {
        return income;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", month=" + month +
                ", revenue=" + revenue +
                ", cost=" + cost +
                ", income=" + income +
                ", totalIncome=" + totalIncome +
                '}';
    }
}
