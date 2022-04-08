package me.dio.web.individuoapi.controller;

import java.util.List;
import java.util.Optional;
import me.dio.web.individuoapi.entity.Individuo;
import me.dio.web.individuoapi.repository.IndividuoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/individuos")
public class IndividuoRestController {

    private final IndividuoRepository repo;

    @Autowired
    public IndividuoRestController(IndividuoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Individuo> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Individuo> getIndividuo(@PathVariable Long id) {
        Optional<Individuo> individuo = repo.findById(id);

        if (individuo.isPresent()) {
            return ResponseEntity.ok(individuo.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Individuo adicionar(@RequestBody Individuo individuo) {
        return repo.save(individuo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repo.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
