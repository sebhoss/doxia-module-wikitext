/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia;

import java.io.PrintWriter;
import java.io.Writer;

import org.apache.maven.doxia.sink.AbstractTextSink;
import org.apache.maven.doxia.sink.SinkEventAttributes;

/**
 * Textile generator.
 * 
 * @see <a href="http://www.txstyle.org/">txtstyle.org</a>
 */
@SuppressWarnings("nls")
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
        write("h1.");
    }

    @Override
    public void sectionTitle1_() {
        write(EOL);
    }

    @Override
    public void sectionTitle2() {
        write("h2.");
    }

    @Override
    public void sectionTitle2_() {
        write(EOL);
    }

    @Override
    public void sectionTitle3() {
        write("h3.");
    }

    @Override
    public void sectionTitle3_() {
        write(EOL);
    }

    @Override
    public void sectionTitle4() {
        write("h4.");
    }

    @Override
    public void sectionTitle4_() {
        write(EOL);
    }

    @Override
    public void sectionTitle5() {
        write("h5.");
    }

    @Override
    public void sectionTitle5_() {
        write(EOL);
    }

    @Override
    public void paragraph() {
        write("p.");
    }

    @Override
    public void paragraph_() {
        write(EOL);
    }

    @Override
    public void comment(final String comment) {
        write("###." + comment + EOL);
    }

    @Override
    public void verbatim(final boolean boxed) {
        write("bc. ");
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

    // Links and Images

    @Override
    public void link(final String name, final SinkEventAttributes attributes) {
        // nop
    }

    // Basics

    @Override
    public void text(final String text) {
        write(text);
    }

    @Override
    public void rawText(final String text) {
        write(text);
    }

    @Override
    public void lineBreak() {
        write(EOL);
    }

    @Override
    public void unknown(final String name, final Object[] requiredParams, final SinkEventAttributes attributes) {
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

    private void write(final String text) {
        writer.write(unifyEOLs(text));
    }

}
