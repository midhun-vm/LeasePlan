package com.midhun.vehiclepricelist.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midhun.vehiclepricelist.entities.VehiclePrice;

public interface VehiclePriceRepository extends JpaRepository<VehiclePrice, Integer> {

}
