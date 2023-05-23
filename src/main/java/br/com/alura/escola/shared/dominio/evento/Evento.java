package br.com.alura.escola.shared.dominio.evento;

import java.time.LocalDateTime;
import java.util.Map;

public interface Evento {

    public LocalDateTime momento();
    public TipoDeEvento tipo();
    public Map<String, Object> informacoes();
}
