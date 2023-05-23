package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.alura.escola.shared.dominio.CPF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    public void setup() {
        this.aluno = new Aluno(new CPF("123.123.123-00"), "Anderson", new Email("anderson@email.com"));
    }

    @Test
    void naoDevePermitirUmAlunoComMaisDeDoisTelefones() {
        MatricularAlunoDTO dados = new MatricularAlunoDTO("Fulano", "123.456.789-00", "fulano@email.com");
        var aluno = dados.criarAluno();
        aluno.adicionarTelefone("21", "123454444");
        aluno.adicionarTelefone("21", "123454444");

        Assertions.assertThrows(IllegalArgumentException.class, () -> aluno.adicionarTelefone("21", "123454444"));
    }
}
