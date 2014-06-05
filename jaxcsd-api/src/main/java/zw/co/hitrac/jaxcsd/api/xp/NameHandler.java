package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Name;

/**
 *
 * @author charles
 */
public class NameHandler {

    public static void handle(Name name, XMLStreamReader r) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();

            if (r.isStartElement()) {
                if ("commonName".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        name.getCommonNames().add(r.getText());
                    }
                } else if ("honorific".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        name.setHonorific(r.getText());
                    }
                } else if ("forename".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        name.setForename(r.getText());
                    }
                } else if ("surname".equals(r.getLocalName())) {
                    r.next();
                    if (r.isCharacters()) {
                        name.setSurname(r.getText());
                    }
                }

            } else if (r.isEndElement()) {
                if ("name".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
}
