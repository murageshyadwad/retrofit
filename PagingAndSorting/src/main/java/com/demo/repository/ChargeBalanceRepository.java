package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.demo.viewmodel.ChargeBalanceView;

@Repository
public interface ChargeBalanceRepository extends JpaRepository<ChargeBalanceView, String> {

}
