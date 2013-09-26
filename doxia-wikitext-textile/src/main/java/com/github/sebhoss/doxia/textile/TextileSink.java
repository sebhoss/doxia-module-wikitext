/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia.textile;

import java.io.PrintWriter;
import java.io.Writer;

import javax.annotation.Nullable;

import com.github.sebhoss.common.annotation.CompilerWarnings;

import org.apache.maven.doxia.sink.AbstractTextSink;
import org.apache.maven.doxia.sink.SinkEventAttributes;

/**
 * Textile Sink.
 */
@SuppressWarnings({ CompilerWarnings.NLS })
public class TextileSink extends AbstractTextSink {

    private final PrintWriter writer;

    /**
     * @param writer
     *            The output writer to use.
     */
    public TextileSink(final Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    // Block modifiers

    @Override
    public void sectionTitle1() {
        write("h1. ");
    }

    @Override
    public void sectionTitle1_() {
        write(EOL);
    }

    @Override
    public void sectionTitle2() {
        write("h2. ");
    }

    @Override
    public void sectionTitle2_() {
        write(EOL);
    }

    @Override
    public void sectionTitle3() {
        write("h3. ");
    }

    @Override
    public void sectionTitle3_() {
        write(EOL);
    }

    @Override
    public void sectionTitle4() {
        write("h4. ");
    }

    @Override
    public void sectionTitle4_() {
        write(EOL);
    }

    @Override
    public void sectionTitle5() {
        write("h5. ");
    }

    @Override
    public void sectionTitle5_() {
        write(EOL);
    }

    @Override
    public void paragraph() {
        write("p. ");
    }

    @Override
    public void paragraph_() {
        write(EOL);
    }

    @Override
    public void comment(final @Nullable String comment) {
        write("###. " + comment + EOL);
    }

    @Override
    public void verbatim(final boolean boxed) {
        if (boxed) {
            write("bc. ");
        } else {
            write("pre. ");
        }
    }

    @Override
    public void verbatim_() {
        write(EOL);
    }

    // Phrase modifiers

    @Override
    public void bold() {
        write("**");
    }

    @Override
    public void bold_() {
        write("**");
    }

    @Override
    public void italic() {
        write("__");
    }

    @Override
    public void italic_() {
        write("__");
    }

    @Override
    public void monospaced() {
        write("@");
    }

    @Override
    public void monospaced_() {
        write("@");
    }

    // Lists

    @Override
    public void definitionList() {
        write("- ");
    }

    @Override
    public void definitionList_() {
        write(EOL);
    }

    @Override
    public void definedTerm_() {
        write(" ");
    }

    @Override
    public void definition() {
        write(":= ");
    }

    @Override
    public void definition_() {
        write(" =:" + EOL);
    }

    // Links and Images

    @Override
    public void link(final @Nullable String name) {
        write("\"" + name + "\":" + name);
    }

    @Override
    public void anchor(final @Nullable String name) {
        write("\"" + name + "\":" + name);
    }

    @Override
    public void figure() {
        write("!");
    }

    @Override
    public void figure_() {
        write("!");
    }

    @Override
    public void figureCaption() {
        write("(");
    }

    @Override
    public void figureCaption_() {
        write(")");
    }

    @Override
    public void figureGraphics(final @Nullable String name) {
        write(name);
    }

    // Tables

    @Override
    public void table() {
        write("|");
    }

    @Override
    public void table_() {
        write(EOL);
    }

    @Override
    public void tableHeaderCell() {
        write("_. ");
    }

    @Override
    public void tableHeaderCell_() {
        write(" |");
    }

    @Override
    public void tableRow() {
        write(EOL + "|");
    }

    @Override
    public void tableCell() {
        write(" ");
    }

    @Override
    public void tableCell_() {
        write(" |");
    }

    // Basics

    @Override
    public void text(final @Nullable String text) {
        write(text);
    }

    @Override
    public void rawText(final @Nullable String text) {
        write("notextile. " + text);
    }

    @Override
    public void lineBreak() {
        write(EOL);
    }

    @Override
    public void unknown(final @Nullable String name, final @Nullable Object[] requiredParams,
            final @Nullable SinkEventAttributes attributes) {
        getLog().warn("[Textile Sink] Unknown Sink event: '" + name + "', ignoring!");
    }

    // Writer specific

    @Override
    public void flush() {
        writer.flush();
    }

    @Override
    public void close() {
        writer.close();
    }

    // Helpers

    private void write(final @Nullable String text) {
        writer.write(unifyEOLs(text));
    }

}
