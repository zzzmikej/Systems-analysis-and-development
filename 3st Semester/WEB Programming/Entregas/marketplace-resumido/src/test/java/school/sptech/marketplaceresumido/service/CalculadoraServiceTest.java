package school.sptech.marketplaceresumido.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    @Test
    @DisplayName("Teste correto se, ao passar 100.0 retorna 18.0")
    void cenarioCorreto1() {
        // GIVEN
//        var service = new CalculadoraService();
        CalculadoraService service = new CalculadoraService();
        Double valorInformado = 100.0;
        Double resultado = 18.0;

        // THEN
        Double resultadoRetornado = service.calculoIcms(valorInformado);

        // ASSERT
        Assertions.assertEquals(resultado, resultadoRetornado);
    }

    @Test
    @DisplayName("Teste incorreto se, ao passar null, deve retornar uma exception")
    void cenarioIncorreto1() {
        // GIVEN
        CalculadoraService service = new CalculadoraService();
        Double valorInformado = null;

        // THEN/ASSERT
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.calculoIcms(valorInformado));

        // CASO EU QUEIRA PEGAR A RESPOSTA DA EXCEPTION E VERIFICAR O TEXTO, CÓDIGO ABAIXO:
        // THEN/ASSERT
//        IllegalArgumentException exception =
//                Assertions.assertThrows(IllegalArgumentException.class,
//                () -> service.calculoIcms(valorInformado));
//
//        // ASSERT
//        Assertions.assertEquals("O valor não pode ser null", exception.getMessage());
    }

    @Test
    @DisplayName("Teste incorreto se, ao passar valor 0 retorna exception")
    void cenarioIncorreto2() {
        //GIVEN
        CalculadoraService service = new CalculadoraService();
        Double valorInformado = 0.0;

        // THEN/ASSERT
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.calculoIcms(valorInformado));
    }

    @Test
    @DisplayName("Teste incorreto se, ao passar valor negativo retorna exception")
    void cenarioIncorreto3() {
        //GIVEN
        CalculadoraService service = new CalculadoraService();
        Double valorInformado = -100.0;

        // THEN/ASSERT
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.calculoIcms(valorInformado));
    }
}