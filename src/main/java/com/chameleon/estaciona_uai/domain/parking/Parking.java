package com.chameleon.estaciona_uai.domain.parking;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import com.chameleon.estaciona_uai.domain.parking.parking_space.ParkingSpace;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ParkingSpace> parkingSpaces;
    
    private LocalTime open;
    private LocalTime close;
    
    private String address;

    private String documentation;
}