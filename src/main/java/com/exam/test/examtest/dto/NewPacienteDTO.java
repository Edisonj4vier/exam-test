package com.exam.test.examtest.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewPacienteDTO {
    private String nombre;
    private int estatura;
    private int peso;
    private Date fechaIngreso;
    private int edad;
    
}
