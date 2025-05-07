package com.chameleon.estaciona_uai.repository;

import com.chameleon.estaciona_uai.domain.parking.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParkingRepository extends JpaRepository<Parking, UUID> {
}
