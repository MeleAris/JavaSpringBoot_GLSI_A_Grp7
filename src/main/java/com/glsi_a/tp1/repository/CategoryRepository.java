package com.glsi_a.tp1.repository;

import com.glsi_a.tp1.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer > {

}
