package br.com.alura.escola.gameficacao.dominio.selo;

import br.com.alura.escola.academico.dominio.aluno.CPF;

import java.util.List;

public interface RepositorioDeSelos {

    void salvar(Selo selo);

    List<Selo> listarTodosOsSelosDeUmAluno(CPF cpf);
}
