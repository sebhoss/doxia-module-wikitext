/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.maven;

import java.io.IOException;
import java.io.Reader;

import org.apache.maven.doxia.parser.AbstractTextParser;
import org.apache.maven.doxia.parser.ParseException;
import org.apache.maven.doxia.sink.Sink;
import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.textile.core.TextileLanguage;

import com.google.common.base.Preconditions;
import com.google.common.io.CharStreams;

/**
 * <p>
 * Doxia parser for Textile documents.
 * </p>
 * 
 * @plexus.component role="org.apache.maven.doxia.parser.Parser" role-hint="textile"
 */
@SuppressWarnings("nls")
public class TextileParser extends AbstractTextParser {

    /**
     * Constructor for a new Doxia Textile parser.
     */
    public TextileParser() {
        // empty constructor to make Checkstyle happy.
    }

    @Override
    public void parse(final Reader reader, final Sink sink) throws ParseException {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(sink);

        this.getLog().info("Parsing Textile document..");

        final String textileContent = readTextileContent(reader);
        this.getLog().info("Textile content is: \n" + textileContent);

        final String htmlContent = parseToHtml(textileContent);
        this.getLog().info("HTML content is: \n" + htmlContent);

        sink.rawText(htmlContent);
        sink.flush();
        sink.close();
    }

    /**
     * @param reader
     * @return
     * @throws ParseException
     */
    private static String readTextileContent(final Reader reader) throws ParseException {
        try {
            return CharStreams.toString(reader);
        } catch (final IOException exception) {
            throw new ParseException("Cannot read input", exception);
        }
    }

    /**
     * @param markupContent
     * @return
     */
    private static String parseToHtml(final String markupContent) {
        if (markupContent != null && !markupContent.isEmpty()) {
            final MarkupParser markupParser = createMarkupParser();

            return markupParser.parseToHtml(markupContent);
        }

        throw new IllegalArgumentException("Cannot parse empty Textile content to HTML!");
    }

    /**
     * @return
     */
    private static MarkupParser createMarkupParser() {
        final MarkupParser markupParser = new MarkupParser();
        markupParser.setMarkupLanguage(new TextileLanguage());

        return markupParser;
    }

}
