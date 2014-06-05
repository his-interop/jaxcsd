package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Extension;

/**
 *
 * @author Charles Chigoriwa
 */
public class ExtensionHandler {
    
    public static void handle(Extension extension, XMLStreamReader r) throws XMLStreamException{
         while (r.hasNext()) {
            r.next();

            if (r.isStartElement()) {
                //TODO: to cater for extensions considering extension types
            }else if (r.isEndElement()) {
                if ("extension".equals(r.getLocalName())) {
                    break;
                }
            }
         }
    }
}
