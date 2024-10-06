package org.syphr.wordplay.lang.english;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EnableDictionaryTest
{
    @ParameterizedTest
    @CsvSource(nullValues = "NULL",
               value = { "NULL,false", ",false", "a,false", "to,true", "two,true", "kAbOb, true", "UPPERCASE,true" })
    void isValid(String word, boolean expected)
    {
        // given
        var dictionary = new EnableDictionary();

        // when
        boolean result = dictionary.isValid(word);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getWords()
    {
        // given
        var dictionary = new EnableDictionary();

        // when
        Set<String> result = dictionary.getWords();

        // then
        assertThat(result).hasSize(172820);
    }
}
