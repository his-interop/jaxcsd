package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganization;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganizations;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderOrganizationsParser extends AbstractCsdParser<ProviderOrganizations>{
    
    private ProviderOrganizationParser providerOrganizationParser=new ProviderOrganizationParser();
    
    
    @Override
    public void parse(ProviderOrganizations providerOrganizations, CsdElement providerOrganizationsElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if(r.isStartElement()){
                if (ORGANIZATION_ELEMENT.elementEquals(r)) {
                    ProviderOrganization providerOrganization=new ProviderOrganization();
                    providerOrganization.setEntityID(r.getAttributeValue("", "entityID"));
                    providerOrganizations.addProviderOrganization(providerOrganization);
                    providerOrganizationParser.parse(providerOrganization, ORGANIZATION_ELEMENT, r, csdParserExtensions);
                }
            }else if (r.isEndElement()) {
                if (providerOrganizationsElement.elementEquals(r)) {
                    break;
                }
            }
         }
    }

    public void setProviderOrganizationParser(ProviderOrganizationParser providerOrganizationParser) {
        this.providerOrganizationParser = providerOrganizationParser;
    }
    
    public static final CsdElement ORGANIZATION_ELEMENT=new CsdElement(CsdElementConstants.ORGANIZATION);
}
