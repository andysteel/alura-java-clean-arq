package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.alura.escola.gameficacao.aplicacao.selo.GeraSeloAlunoNovato;
import br.com.alura.escola.gameficacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

public class Main {
    public static void main(String[] args) {

        var nome = "Fulano da Silva";
        var cpf = "123.456.789-00";
        var email = "fulano@email.com";

        var publicadorDeEventos = new PublicadorDeEventos();
        var repositorioDeSelos = new RepositorioDeSelosEmMemoria();
        publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
        publicadorDeEventos.adicionar(new GeraSeloAlunoNovato(repositorioDeSelos));

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicadorDeEventos);
        matricularAluno.executa(new MatricularAlunoDTO(nome, cpf, email));

    }
}