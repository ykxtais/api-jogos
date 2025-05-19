package com.jogosapi.apijogos.mapper;

import com.jogosapi.apijogos.dto.JogoDTO;
import com.jogosapi.apijogos.model.Jogo;
import org.springframework.stereotype.Component;

@Component
public class JogoMapper {
    public Jogo toEntity(JogoDTO dto) {
        Jogo jogo = new Jogo();
        jogo.setNome(dto.getNome());
        jogo.setDescricao(dto.getDescricao());
        jogo.setFaixaEtaria(dto.getFaixaEtaria());
        jogo.setAnoLancamento(dto.getAnoLancamento());
        return jogo;
    }

    public JogoDTO toDTO(Jogo jogo) {
        JogoDTO dto = new JogoDTO();
        dto.setId(jogo.getId());
        dto.setNome(jogo.getNome());
        dto.setDescricao(jogo.getDescricao());
        dto.setFaixaEtaria(jogo.getFaixaEtaria());
        dto.setAnoLancamento(jogo.getAnoLancamento());
        return dto;
    }
}
