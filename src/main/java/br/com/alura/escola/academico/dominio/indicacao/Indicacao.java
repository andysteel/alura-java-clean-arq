package br.com.alura.escola.academico.dominio.indicacao;

import br.com.alura.escola.academico.dominio.aluno.Aluno;

import java.time.LocalDateTime;

public class Indicacao {

    private final Aluno indicante;
    private final Aluno indicado;
    private final LocalDateTime dataIndicacao;

    public Indicacao(final Aluno indicante, final Aluno indicado) {
        this.indicante = indicante;
        this.indicado = indicado;
        this.dataIndicacao = LocalDateTime.now();
    }

    public Aluno getIndicante() {
        return indicante;
    }

    public Aluno getIndicado() {
        return indicado;
    }

    public LocalDateTime getDataIndicacao() {
        return dataIndicacao;
    }
}
