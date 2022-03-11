package me.dio.web.individuoapi.controller;

import me.dio.web.individuoapi.repository.IndividuoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/individuos")
public class IndividuoRestController {
    private IndividuoRepository repo;
    
    @Autowired
    public IndividuoRestController(IndividuoRepository repo) {
        this.repo = repo;
    }
    @GetMapping
    public String getIndividuo(){
        return "TESTE API DE INDIVIDUO";
    }
    
}
