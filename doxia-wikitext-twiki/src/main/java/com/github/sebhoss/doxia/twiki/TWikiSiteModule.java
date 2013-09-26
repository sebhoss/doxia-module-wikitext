/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.doxia.twiki;

import javax.inject.Inject;

import org.apache.maven.doxia.module.site.AbstractSiteModule;
import org.apache.maven.doxia.module.site.SiteModule;
import org.codehaus.plexus.component.annotations.Component;

import com.github.sebhoss.common.annotation.CompilerWarnings;

/**
 * <p>
 * Doxia site module for TWiki sources. All sources must be located under the <em>twiki</em> folder and have an
 * <code>twiki</code> file extension.
 * </p>
 */
@Component(role = SiteModule.class, hint = "twiki")
public class TWikiSiteModule extends AbstractSiteModule {

    /** Folder prefix for TWiki sources. */
    @SuppressWarnings(CompilerWarnings.NLS)
    public static final String SOURCE_DIRECTORY = "twiki";

    /** File extension for TWiki sources. */
    public static final String FILE_EXTENSION   = TWikiSiteModule.SOURCE_DIRECTORY;

    /** ID of the TWiki parser. */
    public static final String PARSER_ID        = TWikiSiteModule.SOURCE_DIRECTORY;

    /**
     * Constructor for a new Maven site module, configured for TWiki sources.
     */
    @Inject
    public TWikiSiteModule() {
        super(TWikiSiteModule.SOURCE_DIRECTORY, TWikiSiteModule.FILE_EXTENSION, TWikiSiteModule.PARSER_ID);
    }

}
