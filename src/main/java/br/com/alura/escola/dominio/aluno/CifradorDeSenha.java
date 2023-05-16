package br.com.alura.escola.dominio.aluno;

public interface CifradorDeSenha {

    public String cifrarSenha(String senha);
    public boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
