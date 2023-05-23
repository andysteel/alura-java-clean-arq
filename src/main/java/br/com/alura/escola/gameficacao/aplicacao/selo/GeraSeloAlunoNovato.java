package br.com.alura.escola.gameficacao.aplicacao.selo;

import br.com.alura.escola.gameficacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gameficacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

import java.util.logging.Logger;

public class GeraSeloAlunoNovato extends Ouvinte {

    private final Logger logger = Logger.getLogger(GeraSeloAlunoNovato.class.getName());

    private final RepositorioDeSelos repositorioDeSelos;

    public GeraSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos) {
        this.repositorioDeSelos = repositorioDeSelos;
    }

    @Override
    protected void reageAo(Evento evento) {
        if(deveProcessar(evento)) {
            var cpf = (CPF)evento.informacoes().get("cpf");
            var selo = new Selo(cpf, "Novato");
            this.repositorioDeSelos.salvar(selo);
            this.logger.info(() -> "Gerado selo de Novato para o Aluno de CPF %s".formatted(cpf.getNumero()));
        }
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }
}
