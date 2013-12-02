/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia.textile;

import javax.inject.Inject;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.apache.maven.doxia.module.site.AbstractSiteModule;
import org.apache.maven.doxia.module.site.SiteModule;
import org.codehaus.plexus.component.annotations.Component;

/**
 * Doxia site module for Textile sources. All sources must be located under the <em>textile</em> folder and have an
 * <code>textile</code> file extension.
 */
@Component(role = SiteModule.class, hint = "textile")
public class TextileSiteModule extends AbstractSiteModule {

    /** Folder prefix for textile sources. */
    @SuppressWarnings(CompilerWarnings.NLS)
    public static final String SOURCE_DIRECTORY = "textile";

    /** File extension for textile sources. */
    public static final String FILE_EXTENSION   = TextileSiteModule.SOURCE_DIRECTORY;

    /** ID of the textile parser. */
    public static final String PARSER_ID        = TextileSiteModule.SOURCE_DIRECTORY;

    /**
     * Constructor for a new Maven site module, configured for textile sources.
     */
    @Inject
    public TextileSiteModule() {
        super(TextileSiteModule.SOURCE_DIRECTORY, TextileSiteModule.FILE_EXTENSION, TextileSiteModule.PARSER_ID);
    }

}
