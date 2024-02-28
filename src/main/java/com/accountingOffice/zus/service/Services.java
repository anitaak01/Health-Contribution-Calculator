package com.accountingOffice.zus.service;

import com.accountingOffice.zus.entity.Company;
import com.accountingOffice.zus.entity.Deduction;

import java.util.List;

public interface Services <T>{
        T findById(long id);
        List <T> findAll();
        void deleteById(long id);

    }
