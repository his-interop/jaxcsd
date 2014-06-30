package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Facility;
import zw.co.hitrac.jaxcsd.api.domain.FacilityDirectory;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityDirectoryParser extends AbstractCsdParser<FacilityDirectory> {

    private FacilityParser facilityParser = new FacilityParser();

    public void parse(FacilityDirectory facilityDirectory, CsdElement facilityDirectoryElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if (facilityElement.elementEquals(r)) {
                    Facility facility = new Facility();
                    facility.setOid(r.getAttributeValue("", "oid"));
                    facilityDirectory.getFacilities().add(facility);
                    facilityParser.parse(facility, facilityElement, r, csdParserExtensions);
                }
            } else if (r.isEndElement()) {
                if (facilityDirectoryElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }

    public void setFacilityParser(FacilityParser facilityParser) {
        this.facilityParser = facilityParser;
    }
    
    public static final CsdElement facilityElement=new CsdElement(FACILITY);
}
