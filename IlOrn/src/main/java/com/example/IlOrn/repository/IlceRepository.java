package com.example.IlOrn.repository;

import com.example.IlOrn.modal.Il;
import com.example.IlOrn.modal.Ilce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IlceRepository extends JpaRepository<Ilce, Long> {
       List<Ilce> findAllByName(String name);
       Optional<Ilce> findByName(String name);
       //
    //Optional<Il> getIlName(String ilName);

       //Optional<Ilce> findById();
//
//        void deleteById(Long id);
//
//
        }

