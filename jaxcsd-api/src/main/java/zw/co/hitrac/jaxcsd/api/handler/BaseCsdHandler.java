package zw.co.hitrac.jaxcsd.api.handler;

import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class BaseCsdHandler<T> {
    
    public abstract void handle(T t, XMLStreamReader r);
    
}
