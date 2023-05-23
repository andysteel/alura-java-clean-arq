package br.com.alura.escola.shared.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CPFTest {

    @Test
    void deveNaoCriarCPFInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("aaa.bbb.ccc-dd"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("111.222-333.44"));
    }

    @Test
    void deveCriarCPFValido() {
        var numero = "000.111.222-00";
        var cpf = new CPF(numero);

        Assertions.assertNotNull(cpf);
        Assertions.assertEquals(numero, cpf.getNumero());
    }
}
