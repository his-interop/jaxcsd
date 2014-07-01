package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganization;
import static zw.co.hitrac.jaxcsd.api.parser.AbstractCsdParser.extensionElement;
import zw.co.hitrac.jaxcsd.api.parser.ext.DefaultFacilityOrganizationExtensionParser;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizationParser extends AbstractCsdParser<FacilityOrganization> {

    private FacilityOrganizationExtensionParser facilityOrganizationExtensionParser = new DefaultFacilityOrganizationExtensionParser();

    @Override
    public void parse(FacilityOrganization facilityOrganization, CsdElement facilityOrganizationElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                //TODO: Add a Facility service handler                
                if (extensionElement.elementEquals(r)) {
                    if (csdParserExtensions != null && csdParserExtensions.getFacilityOrganizationExtensionParser() != null) {
                        csdParserExtensions.getFacilityOrganizationExtensionParser().parse(facilityOrganization, extensionElement, r, csdParserExtensions);
                    } else {
                        this.facilityOrganizationExtensionParser.parse(facilityOrganization, extensionElement, r, csdParserExtensions);
                    }
                }

            } else if (r.isEndElement()) {
                if (facilityOrganizationElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }

    public void setFacilityOrganizationExtensionParser(FacilityOrganizationExtensionParser facilityOrganizationExtensionParser) {
        this.facilityOrganizationExtensionParser = facilityOrganizationExtensionParser;
    }
}
