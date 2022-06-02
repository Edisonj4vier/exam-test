package com.exam.test.examtest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.test.examtest.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    public List<Paciente> findByName(String criteria);
    
}
