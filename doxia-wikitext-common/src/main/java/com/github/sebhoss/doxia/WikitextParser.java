/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia;

import java.io.IOException;
import java.io.Reader;

import javax.annotation.Nullable;

import org.apache.maven.doxia.parser.AbstractTextParser;
import org.apache.maven.doxia.parser.ParseException;
import org.apache.maven.doxia.sink.Sink;
import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.core.parser.markup.MarkupLanguage;

import com.github.sebhoss.common.annotation.CompilerWarnings;
import com.github.sebhoss.common.annotation.Nullsafe;
import com.google.common.base.Preconditions;
import com.google.common.io.CharStreams;

/**
 * Doxia parser based on Wikitext.
 */
@SuppressWarnings(CompilerWarnings.NLS)
public abstract class WikitextParser extends AbstractTextParser {

    @Override
    public void parse(final @Nullable Reader reader, final @Nullable Sink sink) throws ParseException {
        Preconditions.checkNotNull(reader, "Cannot read from NULL reader");
        Preconditions.checkNotNull(sink, "Cannot write into NULL sink");

        final String textileContent = WikitextParser.readTextileContent(reader);
        final String htmlContent = parseToHtml(textileContent);

        sink.rawText(htmlContent);
        sink.flush();
        sink.close();
    }

    private static String readTextileContent(final Reader reader) throws ParseException {
        try (Reader autoClosedReader = reader) {
            return Nullsafe.nullsafe(CharStreams.toString(autoClosedReader));
        } catch (final IOException exception) {
            throw new ParseException("Cannot read input", exception);
        }
    }

    private String parseToHtml(final String markupContent) {
        Preconditions.checkNotNull(markupContent, "Cannot parse NULL Textile content to HTML!");
        Preconditions.checkArgument(!markupContent.isEmpty(), "Cannot parse empty Textile content to HTML!");

        return Nullsafe.nullsafe(createMarkupParser().parseToHtml(markupContent));
    }

    private MarkupParser createMarkupParser() {
        final MarkupParser markupParser = new MarkupParser();
        markupParser.setMarkupLanguage(createMarkupLanguage());

        return markupParser;
    }

    protected abstract MarkupLanguage createMarkupLanguage();

}
