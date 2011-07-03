package org.apache.maven.doxia.module.textile;

import java.io.Writer;

import org.apache.maven.doxia.sink.AbstractTextSinkFactory;
import org.apache.maven.doxia.sink.Sink;

/**
 * <p>
 * Doxia sink factory for the Textile documents.
 * </p>
 * 
 * @author 				Sebastian Hoß (mail@shoss.de)
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
