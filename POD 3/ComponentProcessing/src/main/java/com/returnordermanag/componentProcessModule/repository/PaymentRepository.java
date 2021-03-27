package com.returnordermanag.componentProcessModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnordermanag.componentProcessModule.model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
