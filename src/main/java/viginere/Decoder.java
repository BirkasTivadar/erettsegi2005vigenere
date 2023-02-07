package viginere;

import java.util.stream.IntStream;

public class Decoder {

    private static final String HUN = "aábcdeéfghiíjklmnoóöőpqrstuúüűvwxyz";

    private static final String ENG = "aabcdeefghiijklmnoooopqrstuuuuvwxyz";

    private static final String VIGENERE = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Decoder() {
    }

    public String fromHunToEng(String text) {
        String textLowerCase = text.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : textLowerCase.toCharArray()) {
            int index = HUN.indexOf(c);
            if (index >= 0) {
                stringBuilder.append(ENG.toCharArray()[index]);
            }
        }
        return stringBuilder.toString().toUpperCase();
    }

    public String getEncodedText(String textOriginal, String keyWord) {
        if (keyWord.length() > 5) throw new IllegalArgumentException("Keyword length is max five letters.");

        String text = fromHunToEng(textOriginal);
        int length = text.length();

        String correctCode = getCorrectCode(keyWord, length);

        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, length)
                .forEach(i -> stringBuilder.append(
                        VIGENERE.charAt(
                                VIGENERE.indexOf(text.charAt(i)) + VIGENERE.indexOf(correctCode.charAt(i))
                        )));
        return stringBuilder.toString();
    }

    private String getCorrectCode(String keyWord, int length) {
        String code = keyWord.toUpperCase();
        int multiplier = length / code.length();
        String longCode = code.repeat(multiplier + 1);
        return longCode.substring(0, length);
    }
}
