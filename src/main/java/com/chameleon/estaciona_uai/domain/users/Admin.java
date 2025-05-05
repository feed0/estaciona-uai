package com.chameleon.estaciona_uai.domain.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Admin extends BaseUser {

    @ManyToOne
    private Manager manager;

}