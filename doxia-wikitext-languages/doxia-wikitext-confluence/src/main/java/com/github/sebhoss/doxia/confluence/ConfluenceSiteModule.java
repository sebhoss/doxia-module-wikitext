/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia.confluence;

import javax.inject.Inject;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.apache.maven.doxia.module.site.AbstractSiteModule;
import org.apache.maven.doxia.module.site.SiteModule;
import org.codehaus.plexus.component.annotations.Component;

/**
 * <p>
 * Doxia site module for Confluence sources. All sources must be located under the <em>confluence</em> folder and have
 * an <code>confluence</code> file extension.
 * </p>
 */
@Component(role = SiteModule.class, hint = "confluence")
public class ConfluenceSiteModule extends AbstractSiteModule {

    /** Folder prefix for Confluence sources. */
    @SuppressWarnings(CompilerWarnings.NLS)
    public static final String SOURCE_DIRECTORY = "confluence";

    /** File extension for Confluence sources. */
    public static final String FILE_EXTENSION   = ConfluenceSiteModule.SOURCE_DIRECTORY;

    /** ID of the Confluence parser. */
    public static final String PARSER_ID        = ConfluenceSiteModule.SOURCE_DIRECTORY;

    /**
     * Constructor for a new Maven site module, configured for Confluence sources.
     */
    @Inject
    public ConfluenceSiteModule() {
        super(ConfluenceSiteModule.SOURCE_DIRECTORY, ConfluenceSiteModule.FILE_EXTENSION,
                ConfluenceSiteModule.PARSER_ID);
    }

}
