package com.jogosapi.apijogos.repository;

import com.jogosapi.apijogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {}
