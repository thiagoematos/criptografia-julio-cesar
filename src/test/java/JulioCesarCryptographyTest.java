import code.nation.desafio.util.JulioCesarCryptography;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JulioCesarCryptographyTest {

    @Test
    public void asdf_bteg() {
        // Given
        String frase = "bteg";
        int numero = 1;

        // When
        String resultadoAtual = JulioCesarCryptography.encrypt(frase, numero);

        // Then
        String resultadoEsperado = "asdf";
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void abc_bdd() {
        // Given
        String frase = "bcd";
        int numero = 1;

        // When
        String resultadoAtual = JulioCesarCryptography.encrypt(frase, numero);

        // Then
        String resultadoEsperado = "abc";
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void wxyz_xyza() {
        // Given
        String frase = "xyza";
        int numero = 1;

        // When
        String resultadoAtual = JulioCesarCryptography.encrypt(frase, numero);

        // Then
        String resultadoEsperado = "wxyz";
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void wxyz_xyza_27() {
        // Given
        String frase = "xyza";
        int numero = 27;

        // When
        String resultadoAtual = JulioCesarCryptography.encrypt(frase, numero);

        // Then
        String resultadoEsperado = "wxyz";
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void wxyz_xyza_30() {
        // Given
        String frase = "abcd";
        int numero = 30;

        // When
        String resultadoAtual = JulioCesarCryptography.encrypt(frase, numero);

        // Then
        String resultadoEsperado = "wxyz";
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void TresCasas() {
        // Given
        String frase = "d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr";
        int numero = 3;

        // When
        String resultadoAtual = JulioCesarCryptography.encrypt(frase, numero);

        // Then
        String resultadoEsperado = "a ligeira raposa marrom saltou sobre o cachorro cansado";
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void ComCaracterEspecial() {
        // Given
        String frase = "1d.d";
        int numero = 3;

        // When
        String resultadoAtual = JulioCesarCryptography.encrypt(frase, numero);

        // Then
        String resultadoEsperado = "1a.a";
        assertEquals(resultadoEsperado, resultadoAtual);
    }

}
