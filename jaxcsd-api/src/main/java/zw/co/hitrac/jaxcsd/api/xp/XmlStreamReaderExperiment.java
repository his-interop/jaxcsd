package zw.co.hitrac.jaxcsd.api.xp;

import java.io.InputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Charles Chigoriwa
 */
public class XmlStreamReaderExperiment {
    
    public static void main(String[] args) throws XMLStreamException{
        XMLInputFactory f=XMLInputFactory.newInstance();
        XMLStreamReader r=f.createXMLStreamReader((InputStream)null);
        while(r.hasNext()){
            r.next();
        }
    }
    
    
}
