package com.example.laboratorio2_grupo2.Repository;

import com.example.laboratorio2_grupo2.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
}
