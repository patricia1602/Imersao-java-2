package br.com.alura.linguagensapi;

import org.springframework.stereotype.Repository;

@Repository
public interface LinguagemRepository extends JPARepository<Linguagem, String> {
    
}
