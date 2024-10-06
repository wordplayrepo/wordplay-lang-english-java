package org.syphr.wordplay.lang.english;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedSet;

import javax.annotation.concurrent.Immutable;

import org.syphr.wordplay.core.lang.InvalidCharacterException;
import org.syphr.wordplay.core.lang.Letter;
import org.syphr.wordplay.core.lang.LetterFactory;

@Immutable
public class EnglishLetterFactory implements LetterFactory
{
    @Override
    public Letter toLetter(char character)
    {
        return toLetter(String.valueOf(character));
    }

    @Override
    public Letter toLetter(String character)
    {
        if (character == null || character.isEmpty() || character.length() > 1) {
            throw new IllegalArgumentException("The given input is missing or two long to be converted to a letter");
        }

        try {
            return EnglishLetter.valueOf(character.toUpperCase());
        } catch (RuntimeException e) {
            throw new InvalidCharacterException("Failed to convert '" + character + "' to a letter", e);
        }
    }

    @Override
    public List<Letter> toLetters(String word)
    {
        if (word == null) {
            return List.of();
        }

        return word.chars().mapToObj(c -> toLetter((char) c)).toList();
    }

    @Override
    public SequencedSet<Letter> getLetters()
    {
        return new LinkedHashSet<>(Arrays.asList(EnglishLetter.values()));
    }
}
