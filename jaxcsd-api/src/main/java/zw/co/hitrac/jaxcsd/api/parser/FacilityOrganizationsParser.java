package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganization;
import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganizations;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizationsParser extends AbstractCsdParser<FacilityOrganizations>{
    
    private FacilityOrganizationParser facilityOrganizationParser=new FacilityOrganizationParser();


    @Override
    public void parse(FacilityOrganizations facilityOrganizations, CsdElement facilityOrganizationsElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
       while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if (ORGANIZATION_ELEMENT.elementEquals(r)) {
                    FacilityOrganization organization = new FacilityOrganization();
                    organization.setOid(r.getAttributeValue("", "oid"));
                    facilityOrganizations.getFacilityOrganizations().add(organization);
                    facilityOrganizationParser.parse(organization,ORGANIZATION_ELEMENT, r, csdParserExtensions);
                }

            } else if (r.isEndElement()) {
                if (facilityOrganizationsElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }

    public void setFacilityOrganizationParser(FacilityOrganizationParser facilityOrganizationParser) {
        this.facilityOrganizationParser = facilityOrganizationParser;
    }
    
    
    
    public static final CsdElement ORGANIZATION_ELEMENT=new CsdElement(CsdElementConstants.ORGANIZATION);
            
}
