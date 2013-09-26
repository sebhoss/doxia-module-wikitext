/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia.textile;

import org.apache.maven.doxia.parser.Parser;
import org.codehaus.plexus.component.annotations.Component;
import org.eclipse.mylyn.wikitext.core.parser.markup.MarkupLanguage;
import org.eclipse.mylyn.wikitext.textile.core.TextileLanguage;

import com.github.sebhoss.doxia.WikitextParser;

/**
 * Doxia parser for Textile documents.
 */
@Component(role = Parser.class, hint = "textile")
public class TextileParser extends WikitextParser {

    @Override
    protected MarkupLanguage createMarkupLanguage() {
        return new TextileLanguage();
    }

}
