package com.jogosapi.apijogos.service;

import com.jogosapi.apijogos.dto.JogoDTO;
import com.jogosapi.apijogos.mapper.JogoMapper;
import com.jogosapi.apijogos.model.Jogo;
import com.jogosapi.apijogos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {
    @Autowired
    private JogoRepository repo;
    @Autowired private JogoMapper mapper;

    public List<JogoDTO> listar() {
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    public JogoDTO salvar(JogoDTO dto) {
        Jogo salvo = repo.save(mapper.toEntity(dto));
        return mapper.toDTO(salvo);
    }

    public JogoDTO atualizar(Long id, JogoDTO dto) {
        Jogo jogo = repo.findById(id).orElseThrow();
        jogo.setNome(dto.getNome());
        jogo.setDescricao(dto.getDescricao());
        jogo.setFaixaEtaria(dto.getFaixaEtaria());
        jogo.setAnoLancamento(dto.getAnoLancamento());
        return mapper.toDTO(repo.save(jogo));
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
