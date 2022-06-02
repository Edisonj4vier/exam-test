package com.exam.test.examtest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.test.examtest.dto.NewPacienteDTO;
import com.exam.test.examtest.dto.PacienteDTO;
import com.exam.test.examtest.exceptions.ResourceNotFoundException;
import com.exam.test.examtest.models.Paciente;
import com.exam.test.examtest.repositories.PacienteRepository;
import com.exam.test.examtest.services.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

    final ModelMapper modelMapper;
    final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(@Autowired PacienteRepository repository, ModelMapper mapper){
        this.pacienteRepository = repository;
        this.modelMapper = mapper;
    }
    
    @Override
    @Transactional
    public PacienteDTO create(NewPacienteDTO pacienteDTO) {
        Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PacienteDTO retrieve(Long id){
        Paciente paciente = pacienteRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Name not fount"));
        return modelMapper.map(paciente, PacienteDTO.class);

    }

    @Override
    @Transactional
    public PacienteDTO update(PacienteDTO pacienteDTO, Long id) {
        Paciente paciente = pacienteRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Name not fout"));

        paciente.setId(id);
        paciente = modelMapper.map(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);

        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Name not foud"));
        pacienteRepository.deleteById(paciente.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteDTO> list() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream().map(paciente -> modelMapper.map(paciente, PacienteDTO.class))
            .collect(Collectors.toList());
    }

}


