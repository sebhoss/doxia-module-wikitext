/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia.tracwiki;

import javax.inject.Inject;

import org.apache.maven.doxia.module.site.AbstractSiteModule;
import org.apache.maven.doxia.module.site.SiteModule;
import org.codehaus.plexus.component.annotations.Component;

import com.github.sebhoss.common.annotation.CompilerWarnings;

/**
 * <p>
 * Doxia site module for TracWiki sources. All sources must be located under the <em>tracwiki</em> folder and have an
 * <code>tracwiki</code> file extension.
 * </p>
 */
@Component(role = SiteModule.class, hint = "tracwiki")
public class TracWikiSiteModule extends AbstractSiteModule {

    /** Folder prefix for TracWiki sources. */
    @SuppressWarnings(CompilerWarnings.NLS)
    public static final String SOURCE_DIRECTORY = "tracwiki";

    /** File extension for TracWiki sources. */
    public static final String FILE_EXTENSION   = TracWikiSiteModule.SOURCE_DIRECTORY;

    /** ID of the TracWiki parser. */
    public static final String PARSER_ID        = TracWikiSiteModule.SOURCE_DIRECTORY;

    /**
     * Constructor for a new Maven site module, configured for TracWiki sources.
     */
    @Inject
    public TracWikiSiteModule() {
        super(TracWikiSiteModule.SOURCE_DIRECTORY, TracWikiSiteModule.FILE_EXTENSION, TracWikiSiteModule.PARSER_ID);
    }

}
