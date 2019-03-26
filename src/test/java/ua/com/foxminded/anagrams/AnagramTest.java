package ua.com.foxminded.anagrams;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AnagramTest {
    Anagram anagram;

    @BeforeEach
    void beforeEachInitialize() {
        anagram = new Anagram();
    }

    @Nested
    @DisplayName("Strategy: happy end ")
    class HappyEnd {
        @Test
        void ShouldMakeAnagramCorrectWhen1Word() {
            assertEquals("edc1ba", anagram.makeAnagram("abc1de"));
        }

        @Test
        void ShouldMakeAnagramCorrectWhen2Word() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f ghhfhf3"));
        }

        @Test
        void ShouldMakeAnagramCorrectWhen3Word() {
            assertEquals("cb1a 2fed3 j4ihj", anagram.makeAnagram("ab1c 2def3 j4hij"));
        }
    }

    @Nested
    @DisplayName("Strategy: Error path")
    class ErrorPath {
        // no error planed
    }

    @Nested
    @DisplayName("Strategy: ñorner cases")
    class CornerCases {
        @Test
        void ShouldMakeAnagramCorrectWhenEmptyWord() {
            assertEquals("", anagram.makeAnagram(""));
        }

        @Test
        void ShouldMakeAnagramCorrectWhenWordIsUnusualSymbols() {
            assertEquals("!@#1$%^&2*()_+3", anagram.makeAnagram("!@#1$%^&2*()_+3"));
        }
    }

    @Nested
    @DisplayName("Strategy: white spaces")
    class Whitespaces {
        @Test
        void ShouldMakeAnagramCorrectWhen2WordAndTab() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f" + '\t' + "ghhfhf3"));
        }

        @Test
        void ShouldMakeAnagramCorrectWhen3WordAndTab() {
            assertEquals("cb1a 2fed3 j4ihj", anagram.makeAnagram("ab1c" + '\t' + "2def3" + '\t' + "j4hij"));
        }

        @Test
        void ShouldMakeAnagramCorrectWhen2WordAndCarriageReturn() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f" + '\r' + "ghhfhf3"));
        }

        @Test
        void ShouldMakeAnagramCorrectWhen3WordAndCarriageReturn() {
            assertEquals("cb1a 2fed3 j4ihj", anagram.makeAnagram("ab1c" + '\r' + "2def3" + '\r' + "j4hij"));
        }

        @Test
        void ShouldMakeAnagramCorrectWhen2WordAndNewline() {
            assertEquals("fhdg12f fhfhhg3", anagram.makeAnagram("fgdh12f" + '\n' + "ghhfhf3"));
        }

        @Test
        void ShouldMakeAnagramCorrectWhen3WordAndNewline() {
            assertEquals("cb1a 2fed3 j4ihj", anagram.makeAnagram("ab1c" + '\n' + "2def3" + '\n' + "j4hij"));
        }
    }

}
