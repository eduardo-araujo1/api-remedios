package com.remedios.controllers;

import com.remedios.remedio.*;
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
        return remedioRepository.findAllByAtivoTrue().stream().map(DadosListagemRemedios::new).toList();}


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarRemedio dados){
        Remedio remedio = remedioRepository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        remedioRepository.deleteById(id);
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public void inativar(@PathVariable Long id){
        Remedio remedio = remedioRepository.getReferenceById(id);
        remedio.inativar();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public void reativar(@PathVariable Long id){
        Remedio remedio = remedioRepository.getReferenceById(id);
        remedio.reativar();
    }

}
