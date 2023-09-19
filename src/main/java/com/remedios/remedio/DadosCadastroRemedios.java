package com.remedios.remedio;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosCadastroRemedios(


        @NotBlank
        String nome,

        @Enumerated
        Via via,

        @NotBlank
        String lote,

        int quantidade,

        @Future
        LocalDate validade,

        @Enumerated
        Laboratorio laboratorio) {
}
