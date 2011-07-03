/*
 * Project: doxia-module-textile
 * Package: org.apache.maven.doxia.module.textile
 * File   : TextileSinkFactory.java
 * Created: Jul 3, 2011 - 6:38:41 PM
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
package org.apache.maven.doxia.module.textile;

import java.io.Writer;

import org.apache.maven.doxia.sink.AbstractTextSinkFactory;
import org.apache.maven.doxia.sink.Sink;

/**
 * <p>
 * Doxia sink factory for the Textile documents.
 * </p>
 * 
 * @author 				Sebastian Hoß (sebastian.hoss@viadee.de)
 * @plexus.component 	role="org.apache.maven.doxia.sink.SinkFactory" role-hint="textile"
 */
public class TextileSinkFactory extends AbstractTextSinkFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Sink createSink(final Writer writer, final String encoding) {
		return new TextileSink();
	}

}
