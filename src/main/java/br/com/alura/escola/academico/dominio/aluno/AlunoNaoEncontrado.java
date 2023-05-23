package br.com.alura.escola.academico.dominio.aluno;

public class AlunoNaoEncontrado extends RuntimeException {

    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno não encontrado com o CPF: ".concat(cpf.getNumero()));
    }
}
