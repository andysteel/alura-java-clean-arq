package br.com.alura.escola.gameficacao.infra.selo;

import br.com.alura.escola.academico.dominio.aluno.CPF;
import br.com.alura.escola.gameficacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gameficacao.dominio.selo.Selo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

    private List<Selo> selos = new ArrayList<>();

    @Override
    public void salvar(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> listarTodosOsSelosDeUmAluno(CPF cpf) {
        return this.selos.stream()
                .filter(s -> s.getCpfDoAluno().equals(cpf))
                .toList();
    }
}
