package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.CODED_TYPE;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.EXTENSION;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.RECORD;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class AbstractCsdParser<T> {
    
    public static final CsdElement codedTypeElement=new CsdElement(CODED_TYPE);
    public static final CsdElement extensionElement=new CsdElement(EXTENSION);
    public static final CsdElement recordElement=new CsdElement(RECORD);
    
    public abstract void parse(T t,CsdElement element, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException;
    
}
