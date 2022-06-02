package com.exam.test.examtest.services;

import java.util.List;

import com.exam.test.examtest.dto.NewPacienteDTO;
import com.exam.test.examtest.dto.PacienteDTO;

public interface PacienteService {

    public PacienteDTO create(NewPacienteDTO pacienteDTO);
    public PacienteDTO retrieve(Long id);
    public PacienteDTO update(NewPacienteDTO pacienteDTO, Long id);
    public void delete(Long id);

    public List<PacienteDTO> list();
    
}
