package br.com.alura.linguagensapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repository;

    @GetMapping("/linguagens")
    public List<Linguagem> getLinguagems() {
        List<Linguagem> linguagens = repository.findByOrdeByRanking();
        return linguagens;
    }

    @PostMapping("/linguagem")
    public Linguagem linguagem(@RequestBody Linguagem linguagem) {
        Linguagem save = repository.save(linguagem);
        return save;
    }

    @GetMapping("/linguagem/{id}")
    public Linguagem obterLinguagemPorId(@PathVariable String id, @RequestBody Linguagem linguagem) {
        return (Linguagem) repository.findById(id);
    }

    @PutMapping("/linguagem/{id}")
    public Linguagem updateLinguagem(@RequestBody Linguagem linguagem) {
        return repository.save(linguagem);
    }

    @DeleteMapping("/linguagem/{id}")
    public void deleteLinguagem(@PathVariable String id) {
        repository.deleteById(id);
    }

}
