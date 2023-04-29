package br.com.alura.escola.aluno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    void naoDeveCriarEmailsComEnderecosInvalidos() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
    }

    @Test
    void deveGriarEmailComEnderecoValido() {
        var endereco = "anderson@gmail.com";
        var email = new Email(endereco);

        Assertions.assertNotNull(email);
        Assertions.assertEquals(endereco, email.getEndereco());
    }
}
