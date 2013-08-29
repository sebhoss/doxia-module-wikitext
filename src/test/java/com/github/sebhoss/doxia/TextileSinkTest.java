/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia;

import java.io.StringWriter;

import org.apache.maven.doxia.markup.Markup;
import org.apache.maven.doxia.sink.Sink;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the {@link TextileSink}.
 */
@SuppressWarnings("nls")
public class TextileSinkTest {

    private StringWriter writer;

    @SuppressWarnings("javadoc")
    @Before
    public void setUp() {
        writer = new StringWriter();
    }

    /**
     * Ensures that the sink supports {@link Sink#sectionTitle1()}.
     */
    @Test
    public void shouldSupportSectionTitle1() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.sectionTitle1();
        sink.text("Title");
        sink.sectionTitle1_();

        // then
        Assert.assertEquals("h1. Title" + Markup.EOL, writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#sectionTitle2()}.
     */
    @Test
    public void shouldSupportSectionTitle2() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.sectionTitle2();
        sink.text("Title");
        sink.sectionTitle2_();

        // then
        Assert.assertEquals("h2. Title" + Markup.EOL, writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#sectionTitle3()}.
     */
    @Test
    public void shouldSupportSectionTitle3() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.sectionTitle3();
        sink.text("Title");
        sink.sectionTitle3_();

        // then
        Assert.assertEquals("h3. Title" + Markup.EOL, writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#sectionTitle4()}.
     */
    @Test
    public void shouldSupportSectionTitle4() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.sectionTitle4();
        sink.text("Title");
        sink.sectionTitle4_();

        // then
        Assert.assertEquals("h4. Title" + Markup.EOL, writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#sectionTitle5()}.
     */
    @Test
    public void shouldSupportSectionTitle5() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.sectionTitle5();
        sink.text("Title");
        sink.sectionTitle5_();

        // then
        Assert.assertEquals("h5. Title" + Markup.EOL, writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#paragraph()}.
     */
    @Test
    public void shouldSupportParagraph() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.paragraph();
        sink.text("text");
        sink.paragraph_();

        // then
        Assert.assertEquals("p. text" + Markup.EOL, writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#comment(String)}.
     */
    @Test
    public void shouldSupportComment() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.comment("comment");

        // then
        Assert.assertEquals("###. comment" + Markup.EOL, writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#verbatim(org.apache.maven.doxia.sink.SinkEventAttributes)}.
     */
    @Test
    public void shouldSupportBoxedVerbatim() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.verbatim(true);
        sink.text("text");
        sink.verbatim_();

        // then
        Assert.assertEquals("bc. text" + Markup.EOL, writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#verbatim(org.apache.maven.doxia.sink.SinkEventAttributes)}.
     */
    @Test
    public void shouldSupportUnboxedVerbatim() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.verbatim(false);
        sink.text("text");
        sink.verbatim_();

        // then
        Assert.assertEquals("pre. text" + Markup.EOL, writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#bold()}.
     */
    @Test
    public void shouldSupportBold() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.bold();
        sink.text("text");
        sink.bold_();

        // then
        Assert.assertEquals("**text**", writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#italic()}.
     */
    @Test
    public void shouldSupportItalic() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.italic();
        sink.text("text");
        sink.italic_();

        // then
        Assert.assertEquals("__text__", writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#monospaced()}.
     */
    @Test
    public void shouldSupportMonospaced() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.monospaced();
        sink.text("text");
        sink.monospaced_();

        // then
        Assert.assertEquals("@text@", writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#text(String)}.
     */
    @Test
    public void shouldSupportText() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.text("text");

        // then
        Assert.assertEquals("text", writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#rawText(String)}.
     */
    @Test
    public void shouldSupportRawText() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.rawText("text");

        // then
        Assert.assertEquals("notextile. text", writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#lineBreak()}.
     */
    @Test
    public void shouldSupportLineBreak() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.lineBreak();

        // then
        Assert.assertEquals(Markup.EOL, writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#link(String)}.
     */
    @Test
    public void shouldSupportLink() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.link("url");

        // then
        Assert.assertEquals("\"url\":url", writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#anchor(String)}.
     */
    @Test
    public void shouldSupportAnchor() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.anchor("url");

        // then
        Assert.assertEquals("\"url\":url", writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#figure()}.
     */
    @Test
    public void shouldSupportFigure() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.figure();
        sink.text("/img/carver.jpeg");
        sink.figure_();

        // then
        Assert.assertEquals("!/img/carver.jpeg!", writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#figureGraphics(String)}.
     */
    @Test
    public void shouldSupportFigureGraphics() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.figure();
        sink.figureGraphics("/img/carver.jpeg");
        sink.figure_();

        // then
        Assert.assertEquals("!/img/carver.jpeg!", writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#figureCaption()}.
     */
    @Test
    public void shouldSupportFigureCaption() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.figure();
        sink.figureGraphics("/img/carver.jpeg");
        sink.figureCaption();
        sink.text("caption");
        sink.figureCaption_();
        sink.figure_();

        // then
        Assert.assertEquals("!/img/carver.jpeg(caption)!", writer.toString());
    }

    /**
     * Ensures that the sink supports {@link Sink#definitionList()}.
     */
    @Test
    public void shouldSupportDefinitionList() {
        // given
        final TextileSink sink = new TextileSink(writer);

        // when
        sink.definitionList();
        sink.definedTerm();
        sink.text("HTML");
        sink.definedTerm_();
        sink.definition();
        sink.text("HyperText Markup Language, based on SGML.");
        sink.definition_();
        sink.definitionList_();

        // then
        Assert.assertEquals("- HTML := HyperText Markup Language, based on SGML. =:" + Markup.EOL + Markup.EOL,
                writer.toString());
    }

}
