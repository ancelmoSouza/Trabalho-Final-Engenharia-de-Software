package com.ufc.br.repository;

import com.ufc.br.model.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
    //Spring Data
    Instrutor findByMatricula(Long matricula);
}
