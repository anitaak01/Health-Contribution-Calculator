package com.accountingOffice.zus.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long companyId;

    private String companyName;
    private String ownerFirstName;

    private String ownerLastName;

    public Company() {
    }

    public Company(String companyName, String ownerFirstName, String ownerLastName) {
        this.companyName = companyName;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    @Override
    public String toString() {
        return companyName + " " + ownerFirstName +" " + ownerLastName;
    }
}

