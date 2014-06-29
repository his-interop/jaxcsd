package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Facility;
import zw.co.hitrac.jaxcsd.api.domain.FacilityDirectory;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityDirectoryParser extends AbstractCsdParser<FacilityDirectory>{
    
    private FacilityParser facilityParser=new FacilityParser();

    public  void parse(FacilityDirectory facilityDirectory, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if ("facility".equals(r.getLocalName())) {
                    Facility facility = new Facility();
                    facility.setOid(r.getAttributeValue("", "oid"));
                    facilityDirectory.getFacilities().add(facility);
                    facilityParser.parse(facility, r,csdParserExtensions);
                }
            } else if (r.isEndElement()) {
                if ("facilityDirectory".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }

    public void setFacilityParser(FacilityParser facilityParser) {
        this.facilityParser = facilityParser;
    }
    
    
}
