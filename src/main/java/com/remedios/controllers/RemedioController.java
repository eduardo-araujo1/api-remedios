package com.remedios.controllers;

import com.remedios.remedio.DadosCadastroRemedios;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroRemedios dados){

        System.out.println(dados);
    }
}
