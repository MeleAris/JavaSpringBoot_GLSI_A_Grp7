package com.glsi_a.tp1.repository;

import com.glsi_a.tp1.models.Approvisionnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ApprovisionnementRepository extends JpaRepository<Approvisionnement, Integer > {
    @Query(value = "select * from Approvisionnement where dateApp in(:d,:f)", nativeQuery = true)
    List<Approvisionnement> filtreApprov(@Param("d") LocalDate d, @Param("f") LocalDate f );
}
