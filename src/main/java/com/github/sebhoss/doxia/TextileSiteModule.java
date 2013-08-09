/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia;

import javax.inject.Inject;

import org.apache.maven.doxia.module.site.AbstractSiteModule;
import org.apache.maven.doxia.module.site.SiteModule;
import org.codehaus.plexus.component.annotations.Component;

/**
 * <p>
 * Doxia site module for Textile sources. All sources must be located under the <em>textile</em> folder and have an
 * <code>textile</code> file extension.
 * </p>
 */
@Component( role = SiteModule.class, hint = "textile" )
public class TextileSiteModule extends AbstractSiteModule {

    /** Folder prefix for textile sources. */
    @SuppressWarnings("nls")
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
