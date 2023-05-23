package br.com.alura.escola.academico.dominio.aluno;

import java.util.Objects;

public class Email {
    private final String endereco;

    public Email(final String endereco) {
        if(Objects.isNull(endereco) ||
                !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email inválido !");
        }
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
