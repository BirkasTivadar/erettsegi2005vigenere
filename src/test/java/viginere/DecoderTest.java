package viginere;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecoderTest {

    Decoder decoder;

    @BeforeEach
    void init() {
        decoder = new Decoder();
    }

    @Test
    void testFromHunToEng() {
        String proba = "Ez a próba szöveg, amit kódolunk!";

        assertEquals("EZAPROBASZOVEGAMITKODOLUNK", decoder.fromHunToEng(proba));
    }

    @Test
    void TestEncoding() {
        String codingText = decoder.getEncodedText("Ez a próba szöveg, amit kódolunk!", "auto");

        assertEquals("ETTDRIUOSTHJEATAINDCDIEINE", codingText);
    }
}