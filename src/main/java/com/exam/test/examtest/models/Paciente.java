package com.exam.test.examtest.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_PACIENTES")
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 100)    
    private String name;
    @Column(name = "ESTATURA")    
    private int estatura;
    @Column(name = "PESO")    
    private int peso;
    @Column(name = "FECHA_INGRESO")    
    private Date fechaIngreso;
    @Column(name = "EDAD")
    private int edad;    
}
