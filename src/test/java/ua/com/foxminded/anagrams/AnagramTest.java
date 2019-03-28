package ua.com.foxminded.anagrams;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AnagramTest {
    private Anagram anagram;

    @BeforeEach
    void setup() {
        anagram = new Anagram();
    }

    @Nested
    @DisplayName("Strategy: happy path ")
    class HappyPath {
        @Test
        void shouldMakeAnagramCorrectWhen1Word() {
            assertEquals("edc1ba", anagram.makeAnagram("abc1de"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen2Word() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f ghhfhf3"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen3Word() {
            assertEquals("cb1a 2fed3 j4ihj", anagram.makeAnagram("ab1c 2def3 j4hij"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen2WordAndTab() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f" + '\t' + "ghhfhf3"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen3WordAndTab() {
            assertEquals("cb1a 2fed3 j4ihj", anagram.makeAnagram("ab1c" + '\t' + "2def3" + '\t' + "j4hij"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen2WordAndCarriageReturn() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f" + '\r' + "ghhfhf3"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen3WordAndCarriageReturn() {
            assertEquals("cb1a 2fed3 j4ihj", anagram.makeAnagram("ab1c" + '\r' + "2def3" + '\r' + "j4hij"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen2WordAndNewline() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f" + '\n' + "ghhfhf3"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen3WordAndNewline() {
            assertEquals("cb1a 2fed3 j4ihj", anagram.makeAnagram("ab1c" + '\n' + "2def3" + '\n' + "j4hij"));
        }
    }

    @Nested
    @DisplayName("Strategy: ñorner cases")
    class CornerCases {
        @Test
        void shouldMakeAnagramCorrectWhenEmptyWord() {
            assertEquals("", anagram.makeAnagram(""));
        }

        @Test
        void shouldMakeAnagramCorrectWhenWordIsUnusualSymbols() {
            assertEquals("!@#1$%^&2*()_+3", anagram.makeAnagram("!@#1$%^&2*()_+3"));
        }
    }

    @Nested
    @DisplayName("Strategy: white spaces")
    class Whitespaces {
        @Test
        void shouldMakeAnagramCorrectWhen2WordAnd2Whitespaces() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f  ghhfhf3"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen3WordAnd2Whitespaces() {
            assertEquals("cb1a 2fed3 j4ihj", anagram.makeAnagram("ab1c  2def3  j4hij"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen2WordAnd2Tabs() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f" + '\t' + '\t' + "ghhfhf3"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen3WordAnd2Tabs() {
            assertEquals("cb1a 2fed3 j4ihj",
                    anagram.makeAnagram("ab1c" + '\t' + '\t' + "2def3" + '\t' + '\t' + "j4hij"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen2WordAnd2CarriageReturns() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f" + '\r' + '\r' + "ghhfhf3"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen3WordAnd2CarriageReturns() {
            assertEquals("cb1a 2fed3 j4ihj",
                    anagram.makeAnagram("ab1c" + '\r' + '\r' + "2def3" + '\r' + '\r' + "j4hij"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen2WordAnd2Newlines() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f" + '\n' + '\n' + "ghhfhf3"));
        }

        @Test
        void shouldMakeAnagramCorrectWhen3WordAnd2Newlines() {
            assertEquals("cb1a 2fed3 j4ihj",
                    anagram.makeAnagram("ab1c" + '\n' + '\n' + "2def3" + '\n' + '\n' + "j4hij"));
        }
    }
}
