package br.com.alura.escola.shared.dominio;

import java.util.Objects;

public class CPF {
    private final String numero;

    public CPF(final String numero) {
        if(Objects.isNull(numero) || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
