import code.nation.desafio.util.SHA1Wrapper;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://pt.wikipedia.org/wiki/SHA-1
public class SHA1Test {

    @Test
    public void a() throws NoSuchAlgorithmException {
        // Given
        String frase = "The quick brown fox jumps over the lazy dog";

        // When
        String resultadoAtual = SHA1Wrapper.execute(frase);

        // Then
        String resultadoEsperado = "2fd4e1c67a2d28fced849ee1bb76e7391b93eb12";
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void b() throws NoSuchAlgorithmException {
        // Given
        String frase = "The quick brown fox jumps over the lazy cog";

        // When
        String resultadoAtual = SHA1Wrapper.execute(frase);

        // Then
        String resultadoEsperado = "de9f2c7fd25e1b3afad3e85a0bd17d9b100db4b3";
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void c() throws NoSuchAlgorithmException {
        // Given
        String frase = "GeeksForGeeks";

        // When
        String resultadoAtual = SHA1Wrapper.execute(frase);

        // Then
        String resultadoEsperado = "addf120b430021c36c232c99ef8d926aea2acd6b";
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void d() throws NoSuchAlgorithmException {
        // Given
        String frase = "hello world";

        // When
        String resultadoAtual = SHA1Wrapper.execute(frase);

        // Then
        String resultadoEsperado = "2aae6c35c94fcfb415dbe95f408b9ce91ee846ed";
        assertEquals(resultadoEsperado, resultadoAtual);
    }

}
