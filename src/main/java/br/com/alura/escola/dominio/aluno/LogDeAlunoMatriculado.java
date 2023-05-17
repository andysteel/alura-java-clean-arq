package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.Evento;
import br.com.alura.escola.dominio.Ouvinte;

import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class LogDeAlunoMatriculado extends Ouvinte {

    private final Logger logger = Logger.getLogger(LogDeAlunoMatriculado.class.getName());

    @Override
    protected void reageAo(Evento evento) {
        var alunoMatriculado = (AlunoMatriculado) evento;
        var momentoFormatado = alunoMatriculado.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.logger.info(String.format("Aluno com CPF %s matriculado em %s", alunoMatriculado.getCpf().getNumero(), momentoFormatado));
    }


    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}