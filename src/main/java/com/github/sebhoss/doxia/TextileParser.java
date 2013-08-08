/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia;

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
        Preconditions.checkNotNull(reader, "Cannot read from NULL reader");
        Preconditions.checkNotNull(sink, "Cannot write into NULL sink");

        final String textileContent = TextileParser.readTextileContent(reader);
        final String htmlContent = TextileParser.parseToHtml(textileContent);

        sink.rawText(htmlContent);
        sink.flush();
        sink.close();
    }

    private static String readTextileContent(final Reader reader) throws ParseException {
        try (Reader autoClosedReader = reader) {
            return CharStreams.toString(autoClosedReader);
        } catch (final IOException exception) {
            throw new ParseException("Cannot read input", exception);
        }
    }

    private static String parseToHtml(final String markupContent) {
        Preconditions.checkNotNull(markupContent, "Cannot parse NULL Textile content to HTML!");
        Preconditions.checkArgument(!markupContent.isEmpty(), "Cannot parse empty Textile content to HTML!");

        final MarkupParser markupParser = TextileParser.createMarkupParser();

        return markupParser.parseToHtml(markupContent);
    }

    private static MarkupParser createMarkupParser() {
        final MarkupParser markupParser = new MarkupParser();
        markupParser.setMarkupLanguage(new TextileLanguage());

        return markupParser;
    }

}
