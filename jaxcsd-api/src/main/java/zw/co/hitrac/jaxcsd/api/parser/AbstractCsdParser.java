package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class AbstractCsdParser<T> {
    
    public abstract void parse(T t, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException;
    
}
