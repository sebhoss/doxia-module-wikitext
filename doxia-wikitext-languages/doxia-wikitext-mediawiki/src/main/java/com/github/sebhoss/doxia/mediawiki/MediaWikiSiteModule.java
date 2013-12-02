/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia.mediawiki;

import javax.inject.Inject;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.apache.maven.doxia.module.site.AbstractSiteModule;
import org.apache.maven.doxia.module.site.SiteModule;
import org.codehaus.plexus.component.annotations.Component;

/**
 * <p>
 * Doxia site module for MediaWiki sources. All sources must be located under the <em>mediawiki</em> folder and have an
 * <code>mediawiki</code> file extension.
 * </p>
 */
@Component(role = SiteModule.class, hint = "mediawiki")
public class MediaWikiSiteModule extends AbstractSiteModule {

    /** Folder prefix for MediaWiki sources. */
    @SuppressWarnings(CompilerWarnings.NLS)
    public static final String SOURCE_DIRECTORY = "mediawiki";

    /** File extension for MediaWiki sources. */
    public static final String FILE_EXTENSION   = MediaWikiSiteModule.SOURCE_DIRECTORY;

    /** ID of the MediaWiki parser. */
    public static final String PARSER_ID        = MediaWikiSiteModule.SOURCE_DIRECTORY;

    /**
     * Constructor for a new Maven site module, configured for MediaWiki sources.
     */
    @Inject
    public MediaWikiSiteModule() {
        super(MediaWikiSiteModule.SOURCE_DIRECTORY, MediaWikiSiteModule.FILE_EXTENSION,
                MediaWikiSiteModule.PARSER_ID);
    }

}
