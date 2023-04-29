package br.com.alura.escola.aluno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TelefoneTest {

    @Test
    void deveNaoCriarTelefonesInvalidos() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("22", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "12345678"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("22", "1234567890"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("223", "12345678"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("bb", "cccddder"));
    }

    @Test
    void deveCriarUmTelefoneValido() {
        var ddd = "21";
        var numero = "123456789";
        var telefone = new Telefone(ddd, numero);

        Assertions.assertNotNull(telefone);
        Assertions.assertEquals(ddd, telefone.getDdd());
        Assertions.assertEquals(numero, telefone.getNumero());
    }
}
