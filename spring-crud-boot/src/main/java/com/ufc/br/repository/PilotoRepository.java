package com.ufc.br.repository;

import com.ufc.br.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto, Long> {
    //Spring Data
    Piloto findByBreve(Long breve);

}
