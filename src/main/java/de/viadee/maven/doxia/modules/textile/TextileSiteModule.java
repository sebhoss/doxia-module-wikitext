/*
 * Project: doxia-module-textile
 * Package: org.apache.maven.doxia.module.textile
 * File   : TextileSiteModule.java
 * Created: Jul 3, 2011 - 6:53:51 PM
 *
 *
 * Copyright 2011 viadee IT Unternehmensberatung GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package de.viadee.maven.doxia.modules.textile;

import org.apache.maven.doxia.module.site.AbstractSiteModule;

/**
 * <p>
 * Doxia site module for Textile sources. All sources must be located under the <em>textile</em> folder and have an
 * <code>.textile</code> file extension.
 * </p>
 * 
 * @author              Sebastian Hoß (sebastian.hoss@viadee.de)
 * @since               1.0.0
 * @plexus.component    role="org.apache.maven.doxia.module.site.SiteModule" role-hint="textile"
 */
public class TextileSiteModule extends AbstractSiteModule {

    /** Folder prefix for textile sources. */
    @SuppressWarnings("nls")
    private static final String SOURCE_DIRECTORY = "textile";

    /** File extension for textile sources. */
    private static final String FILE_EXTENSION   = TextileSiteModule.SOURCE_DIRECTORY;

    /** ID of the textile parser. */
    private static final String PARSER_ID        = TextileSiteModule.SOURCE_DIRECTORY;

    /**
     * Constructor for a new Maven site module, configured for textile sources.
     */
    public TextileSiteModule() {
        super(TextileSiteModule.SOURCE_DIRECTORY, TextileSiteModule.FILE_EXTENSION, TextileSiteModule.PARSER_ID);
    }

}
