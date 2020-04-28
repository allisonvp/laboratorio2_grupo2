package com.example.laboratorio2_grupo2.Repository;

import com.example.laboratorio2_grupo2.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer> {
}
