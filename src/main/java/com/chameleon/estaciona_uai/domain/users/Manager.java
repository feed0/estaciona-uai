package com.chameleon.estaciona_uai.domain.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.chameleon.estaciona_uai.domain.parking.Parking;

@Entity
@Getter
@Setter
public class Manager extends BaseUser {
    @OneToOne(mappedBy = "manager", cascade = CascadeType.ALL)
    private Parking parking;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Admin> admins;
}