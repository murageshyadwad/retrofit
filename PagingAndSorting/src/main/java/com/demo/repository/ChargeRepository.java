package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.demo.model.Charge;



@Repository
public interface ChargeRepository extends JpaRepository<Charge, Long> {
Optional<Charge> findById(Long chargeid);
}
