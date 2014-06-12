package zw.co.hitrac.jaxcsd.api.xp;

import java.io.ByteArrayInputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ValueSet;
import zw.co.hitrac.jaxcsd.api.svs.RetrieveValueSetResponse;

/**
 *
 * @author Charles Chigoriwa
 */
public class RetrieveValueSetResponseHandler {

    public static RetrieveValueSetResponse getRetrieveValueSetResponse(String xmlBody) throws XMLStreamException {
        RetrieveValueSetResponse retrieveValueSetResponse = null;
        XMLInputFactory f = XMLInputFactory.newInstance();
        XMLStreamReader r = f.createXMLStreamReader(new ByteArrayInputStream(xmlBody.getBytes()));
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                String localName = r.getLocalName();
                if ("RetrieveValueSetResponse".equals(localName)) {
                    retrieveValueSetResponse = new RetrieveValueSetResponse();
                    retrieveValueSetResponse.setId(r.getAttributeValue("", "id"));
                    retrieveValueSetResponse.setVersion(r.getAttributeValue("", "version"));
                } else if ("ValueSet".equals(localName)) {
                    if (retrieveValueSetResponse != null) {
                        ValueSet valueSet = new ValueSet();
                        valueSet.setId(r.getAttributeValue("", "id"));
                        valueSet.setVersion(r.getAttributeValue("", "version"));
                        valueSet.setDisplayName(r.getAttributeValue("", "displayName"));
                        retrieveValueSetResponse.addValueSet(valueSet);
                        ValueSetHandler.handle(valueSet, r);
                    }
                }
            }

        }
        return retrieveValueSetResponse;
    }
}
