package br.com.alura.linguagensapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinguagemRepository extends JpaRepository<Linguagem, Long> {

    Linguagem save(Linguagem linguagem);

    List<Linguagem> findByOrdeByRanking();

    Object findById(String id);

    void deleteById(String id);

}
