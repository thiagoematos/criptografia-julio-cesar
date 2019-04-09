package code.nation.desafio.util;

import static java.lang.Character.isAlphabetic;
import static java.util.stream.Collectors.joining;

public class JulioCesarCryptography {

    private static final int QUANTITY_OF_LETTERS = 26;

    public static String encrypt(String expression, int number) {
        return expression
                .chars()
                .map(character -> logic(character, number))
                .mapToObj(character -> (char) character)
                .map(String::valueOf)
                .collect(joining());
    }

    private static int logic(int character, int number) {
        number = number % QUANTITY_OF_LETTERS;

        var result = character;
        if (isAlphabetic(character)) {
            result = character - number;

            if (result < 'a') {
                result = result + QUANTITY_OF_LETTERS;
            }
        }

        return result;
    }

}
