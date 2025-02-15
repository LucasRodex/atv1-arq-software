package com.atv1.DesFrameworks.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atv1.DesFrameworks.entities.Equipamento;
import com.atv1.DesFrameworks.repositories.EquipamentosRepository;

@Service

public class EquipamentoService {
	
	@Autowired
	private EquipamentosRepository repository;
	
	public Equipamento insert(Equipamento equipamento) {
		return repository.save(equipamento);
	}
	
	public void delete(Long id) {
		if (repository.existsById(id)) {
			
		}
		repository.deleteById(id);
	}

	public List<Equipamento> findAll() {
		return repository.findAll();
	}

	public Equipamento findById(Long id) {
	    Optional<Equipamento> obj = repository.findById(id);
	    return obj.orElseThrow(RuntimeException::new);
	}

	public Equipamento update(Equipamento equipamento) {
		return repository.save(equipamento);
	}

	
	}

