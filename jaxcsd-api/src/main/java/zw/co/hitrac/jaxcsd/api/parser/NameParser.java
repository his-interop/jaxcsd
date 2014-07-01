package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Name;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class NameParser extends AbstractCsdParser<Name> {

    @Override
    public void parse(Name name, CsdElement nameElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
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
                if (nameElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }
}
