/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia;

import java.io.Writer;

import org.apache.maven.doxia.sink.AbstractTextSinkFactory;
import org.apache.maven.doxia.sink.Sink;

/**
 * Textile implementation of the Sink factory.
 */
public class TextileSinkFactory extends AbstractTextSinkFactory {

    @Override
    protected Sink createSink(final Writer writer, final String encoding) {
        return new TextileSink(writer);
    }

}
