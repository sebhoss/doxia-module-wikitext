/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia.textile;

import java.io.StringReader;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.apache.maven.doxia.parser.ParseException;
import org.apache.maven.doxia.sink.Sink;
import org.apache.maven.doxia.sink.SinkEventTestingSink;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the {@link TextileParser}.
 */
@SuppressWarnings({ CompilerWarnings.JAVADOC, CompilerWarnings.NLS })
public class TextileParserTest {

    private SinkEventTestingSink sink;
    private TextileParser        parser;

    @Before
    public void setUp() {
        sink = new SinkEventTestingSink();
        parser = new TextileParser();
    }

    /**
     * Ensures that the parser uses {@link Sink#rawText(String)} to write its output.
     */
    @Test
    public void shouldUseRawText() throws ParseException {
        // given
        final StringReader reader = new StringReader("h1. Title");

        // when
        parser.parse(reader, sink);

        // then
        Assert.assertEquals("rawText", sink.getEventList().get(0).getName());
    }

    /**
     * Ensures that the parser uses {@link Sink#rawText(String)} to write its output.
     */
    @Test
    public void shouldFlush() throws ParseException {
        // given
        final StringReader reader = new StringReader("h1. Title");

        // when
        parser.parse(reader, sink);

        // then
        Assert.assertEquals("flush", sink.getEventList().get(1).getName());
    }

    /**
     * Ensures that the parser uses {@link Sink#rawText(String)} to write its output.
     */
    @Test
    public void shouldClose() throws ParseException {
        // given
        final StringReader reader = new StringReader("h1. Title");

        // when
        parser.parse(reader, sink);

        // then
        Assert.assertEquals("close", sink.getEventList().get(2).getName());
    }

    @Test
    public void shouldNotOutputDoublePreTagsForSingleBlockCodeElement() throws ParseException {
        // given
        final StringReader reader = new StringReader("bc. \\alert(1);");

        // when
        parser.parse(reader, sink);

        // then
        Assert.assertFalse(sink.getEventList().get(0).getArgs()[0].toString().contains("<pre><pre>"));
    }

}
