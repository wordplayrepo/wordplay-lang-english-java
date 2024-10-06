/*
 * Copyright © 2012-2024 Gregory P. Moyer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
