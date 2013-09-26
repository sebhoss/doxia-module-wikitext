/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia.textile;

import java.io.Writer;

import javax.annotation.Nullable;

import org.apache.maven.doxia.sink.AbstractTextSinkFactory;
import org.apache.maven.doxia.sink.Sink;

import com.github.sebhoss.common.annotation.Nullsafe;

/**
 * Textile implementation of the Sink factory.
 */
public class TextileSinkFactory extends AbstractTextSinkFactory {

    @Override
    protected Sink createSink(final @Nullable Writer writer, final @Nullable String encoding) {
        return new TextileSink(Nullsafe.nullsafe(writer));
    }

}
