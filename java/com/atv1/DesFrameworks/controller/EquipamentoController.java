package com.atv1.DesFrameworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atv1.DesFrameworks.Service.EquipamentoService;
import com.atv1.DesFrameworks.entities.Equipamento;

@RestController
@RequestMapping(value = "/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping
    public ResponseEntity<List<Equipamento>> findAll() {
        List<Equipamento> list = equipamentoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Equipamento> findById(@PathVariable Long id) {
        Equipamento obj = equipamentoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Equipamento> insert(@RequestBody Equipamento equipamento) {
        Equipamento obj = equipamentoService.insert(equipamento);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/{id}")
	public ResponseEntity<Equipamento> update(@PathVariable Long id, @RequestBody Equipamento equipamento) {
		Equipamento obj = equipamentoService.update(equipamento);
		return ResponseEntity.ok().body(obj);
	}
}
