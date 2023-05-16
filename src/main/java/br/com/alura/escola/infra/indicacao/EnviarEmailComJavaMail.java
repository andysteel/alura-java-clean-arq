package br.com.alura.escola.infra.indicacao;

import br.com.alura.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.escola.dominio.aluno.Aluno;

public class EnviarEmailComJavaMail implements EnviarEmailIndicacao {

    @Override
    public void enviarPara(Aluno aluno) {
        //logica de envio de email com a lib Java Mail
    }
}
