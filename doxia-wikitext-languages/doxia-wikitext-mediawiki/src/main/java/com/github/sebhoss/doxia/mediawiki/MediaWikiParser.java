/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia.mediawiki;

import org.apache.maven.doxia.parser.Parser;
import org.codehaus.plexus.component.annotations.Component;
import org.eclipse.mylyn.wikitext.core.parser.markup.MarkupLanguage;
import org.eclipse.mylyn.wikitext.mediawiki.core.MediaWikiLanguage;

import com.github.sebhoss.doxia.AbstractWikitextParser;

/**
 * Doxia parser for MediaWiki documents.
 */
@Component(role = Parser.class, hint = "mediawiki")
public class MediaWikiParser extends AbstractWikitextParser {

    @Override
    protected MarkupLanguage createMarkupLanguage() {
        return new MediaWikiLanguage();
    }

}
