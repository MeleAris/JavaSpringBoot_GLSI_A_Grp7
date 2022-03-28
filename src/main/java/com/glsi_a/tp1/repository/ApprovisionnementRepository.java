package com.glsi_a.tp1.repository;

import com.glsi_a.tp1.models.Approvisionnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovisionnementRepository extends JpaRepository<Approvisionnement, Integer > {

}
