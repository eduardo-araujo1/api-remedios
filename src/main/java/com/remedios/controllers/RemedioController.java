package com.remedios.controllers;

import com.remedios.remedio.DadosCadastroRemedios;
import com.remedios.remedio.DadosListagemRemedios;
import com.remedios.remedio.Remedio;
import com.remedios.remedio.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
     private RemedioRepository remedioRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedios dados){
        remedioRepository.save(new Remedio(dados));
    }

    @GetMapping
    public List<DadosListagemRemedios> listar(){
        return remedioRepository.findAll().stream().map(DadosListagemRemedios::new).toList();
    }
}
