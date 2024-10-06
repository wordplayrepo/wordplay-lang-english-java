package org.syphr.wordplay.lang.english;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.concurrent.Immutable;

import org.syphr.wordplay.core.lang.Dictionary;

@Immutable
public class EnableDictionary implements Dictionary
{
    private static final String DICTIONARY_RESOURCE = "enable-dictionary.txt";

    private static final Set<String> WORDS;
    static {
        try (var reader = new BufferedReader(new InputStreamReader(EnableDictionary.class.getResourceAsStream(DICTIONARY_RESOURCE)))) {
            WORDS = reader.lines().collect(Collectors.toSet());
        } catch (IOException e) {
            throw new IllegalStateException("ENABLE dictionary resource is missing!");
        }
    }

    @Override
    public boolean isValid(String word)
    {
        if (word == null || word.length() < 2) {
            return false;
        }

        return WORDS.contains(word.toLowerCase());
    }

    @Override
    public Set<String> getWords()
    {
        return Set.copyOf(WORDS);
    }

    @Override
    public String toString()
    {
        return "ENABLE";
    }
}
