package com.chameleon.estaciona_uai.service;

import com.chameleon.estaciona_uai.domain.parking.Parking;
import com.chameleon.estaciona_uai.domain.users.Manager;
import com.chameleon.estaciona_uai.dto.request.ManagerSignupRequestDto;
import com.chameleon.estaciona_uai.repository.ManagerRepository;
import com.chameleon.estaciona_uai.repository.ParkingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignupService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // You'll need a PasswordEncoder bean configured

    @Transactional
    public void signupManager(ManagerSignupRequestDto signupRequest) {
        // Check if a user with the same email already exists
        if (managerRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            throw new RuntimeException("User with this email already exists");
        }

        // Create Manager entity
        Manager manager = new Manager();
        manager.setName(signupRequest.getFullName());
        manager.setEmail(signupRequest.getEmail());
        manager.setPassword(passwordEncoder.encode(signupRequest.getPassword())); // Encode the password

        // Create Parking entity
        Parking parking = new Parking();
        parking.setName(signupRequest.getParkingName());
        parking.setAddress(signupRequest.getParkingAddress());
        parking.setManager(manager); // Set the manager for the parking

        // Set the parking for the manager as well
        manager.setParking(parking);

        // Save Manager and Parking
        managerRepository.save(manager);
        parkingRepository.save(parking);
    }
}
