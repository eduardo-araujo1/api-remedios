package com.remedios.controllers;

import com.remedios.remedio.DadosCadastroRemedios;
import com.remedios.remedio.Remedio;
import com.remedios.remedio.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
     private RemedioRepository remedioRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroRemedios dados){
        remedioRepository.save(new Remedio(dados));
    }
}
