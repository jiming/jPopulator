/*
 * The MIT License
 *
 *   Copyright (c) 2014, Mahmoud Ben Hassine (md.benhassine@gmail.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */

package io.github.benas.jpopulator.randomizers;

import io.github.benas.jpopulator.api.Randomizer;

import java.util.Random;

/**
 * A generic randomizer that generate String values from a list of words.
 *
 * @author Mahmoud Ben Hassine (md.benhassine@gmail.com)
 */
public class GenericStringRandomizer implements Randomizer<String> {

    private final Random random = new Random();

    /**
     * Words array from which the random value should be chosen randomly.
     */
    private final String[] words;

    /**
     * Public constructor.
     * @param words the words array from which generate a random String.
     */
    public GenericStringRandomizer(final String[] words) {
        this.words = words;
    }

    @Override
    public String getRandomValue() {
        return words[random.nextInt(words.length)];
    }

}
