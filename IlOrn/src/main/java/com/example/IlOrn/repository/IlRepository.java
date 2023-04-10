package com.example.IlOrn.repository;

import com.example.IlOrn.modal.Il;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IlRepository extends JpaRepository<Il, Long> {

      @Query(value = "SELECT * FROM ornek.il WHERE name= :name ;",nativeQuery = true)
      public Il findByName(@Param("name") String name);

    //  Optional<Il> getIlById(Long id);
//    Optional <Il>findById();
//
//    void deleteById(Long id);


}
