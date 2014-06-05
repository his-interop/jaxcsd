package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Facility;
import zw.co.hitrac.jaxcsd.api.domain.FacilityDirectory;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityDirectoryHandler {

    public static void handle(FacilityDirectory facilityDirectory, XMLStreamReader r) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();

            if (r.isStartElement()) {

                if ("facility".equals(r.getLocalName())) {
                    Facility facility = new Facility();
                    facility.setOid(r.getAttributeValue("", "oid"));
                    facilityDirectory.getFacilities().add(facility);
                    FacilityHandler.handle(facility, r);
                }

            } else if (r.isEndElement()) {
                if ("facilityDirectory".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
}
