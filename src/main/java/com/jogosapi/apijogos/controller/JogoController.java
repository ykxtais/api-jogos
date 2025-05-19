package com.jogosapi.apijogos.controller;

import com.jogosapi.apijogos.dto.JogoDTO;
import com.jogosapi.apijogos.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    @Autowired
    private JogoService service;

    @GetMapping
    public List<JogoDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public JogoDTO salvar(@RequestBody JogoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public JogoDTO atualizar(@PathVariable Long id, @RequestBody JogoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
