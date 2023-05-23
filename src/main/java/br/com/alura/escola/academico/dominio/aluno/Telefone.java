package br.com.alura.escola.academico.dominio.aluno;

import java.util.Objects;

public class Telefone {

    private final String ddd;
    private final String numero;

    public Telefone(final String ddd, final String numero) {
        if((Objects.isNull(ddd) || !ddd.matches("\\d{2}")) ||
                (Objects.isNull(numero) || !numero.matches("\\d{8,9}"))) {
            throw new IllegalArgumentException("telefone inválido !!");
        }
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
