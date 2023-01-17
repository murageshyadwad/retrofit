package com.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.demo.model.Charge;
import com.demo.viewmodel.ChargeBalanceView;
import com.demo.viewmodel.ChargeViewModel;



@Repository
public interface ChargeRepository extends JpaRepository<Charge, Long> {

Charge findById(long chargeid);
//Charge save(Charge aptTemp);

ChargeBalanceView save(ChargeBalanceView chargebal);
}
