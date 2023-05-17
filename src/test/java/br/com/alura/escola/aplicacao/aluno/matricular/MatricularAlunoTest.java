package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatricularAlunoTest {

    @Test
    void devePersistirAluno() {
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);

        MatricularAlunoDTO dados = new MatricularAlunoDTO("Fulano", "123.456.789-00", "fulano@email.com");
        useCase.executa(dados);

        var aluno = repositorio.buscarPorCPF(new CPF("123.456.789-00"));

        Assertions.assertEquals("Fulano", aluno.getNome());
        Assertions.assertEquals("123.456.789-00", aluno.getCpf());
        Assertions.assertEquals("fulano@email.com", aluno.getEmail());
    }
}
