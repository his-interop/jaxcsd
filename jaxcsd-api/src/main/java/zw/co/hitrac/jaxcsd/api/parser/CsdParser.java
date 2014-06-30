package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CSD;
import zw.co.hitrac.jaxcsd.api.domain.FacilityDirectory;
import zw.co.hitrac.jaxcsd.api.domain.OrganizationDirectory;
import zw.co.hitrac.jaxcsd.api.domain.ProviderDirectory;
import zw.co.hitrac.jaxcsd.api.domain.ServiceDirectory;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class CsdParser extends AbstractCsdParser<CSD> {

    private OrganizationDirectoryParser organizationDirectoryParser = new OrganizationDirectoryParser();
    private FacilityDirectoryParser facilityDirectoryParser = new FacilityDirectoryParser();
    private ProviderDirectoryParser providerDirectoryParser = new ProviderDirectoryParser();
    private ServiceDirectoryParser serviceDirectoryParser = new ServiceDirectoryParser();

    @Override
    public void parse(final CSD csd, CsdElement csdElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {

        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if (organizationDirectoryElement.elementEquals(r)) {
                    if (csd != null) {
                        csd.setOrganizationDirectory(new OrganizationDirectory());
                        organizationDirectoryParser.parse(csd.getOrganizationDirectory(), organizationDirectoryElement, r, csdParserExtensions);
                    }
                } else if (serviceDirectoryElement.elementEquals(r)) {
                    if (csd != null) {
                        csd.setServiceDirectory(new ServiceDirectory());
                        serviceDirectoryParser.parse(csd.getServiceDirectory(), serviceDirectoryElement, r, csdParserExtensions);
                    }
                } else if (facilityDirectoryElement.elementEquals(r)) {
                    if (csd != null) {
                        csd.setFacilityDirectory(new FacilityDirectory());
                        facilityDirectoryParser.parse(csd.getFacilityDirectory(), facilityDirectoryElement, r, csdParserExtensions);
                    }
                } else if (providerDirectoryElement.elementEquals(r)) {
                    if (csd != null) {
                        csd.setProviderDirectory(new ProviderDirectory());
                        providerDirectoryParser.parse(csd.getProviderDirectory(), providerDirectoryElement, r, csdParserExtensions);
                    }
                }
            }else if(r.isEndElement()){
                if(csdElement.elementEquals(r)){
                    break;
                }
            }

        }

    }

    public void setOrganizationDirectoryParser(OrganizationDirectoryParser organizationDirectoryParser) {
        this.organizationDirectoryParser = organizationDirectoryParser;
    }

    public void setFacilityDirectoryParser(FacilityDirectoryParser facilityDirectoryParser) {
        this.facilityDirectoryParser = facilityDirectoryParser;
    }

    public ProviderDirectoryParser getProviderDirectoryParser() {
        return providerDirectoryParser;
    }

    public void setProviderDirectoryParser(ProviderDirectoryParser providerDirectoryParser) {
        this.providerDirectoryParser = providerDirectoryParser;
    }

    public void setServiceDirectoryParser(ServiceDirectoryParser serviceDirectoryParser) {
        this.serviceDirectoryParser = serviceDirectoryParser;
    }
    
    public static final CsdElement organizationDirectoryElement = new CsdElement(ORGANIZATION_DIRECTORY);
    public static final CsdElement serviceDirectoryElement = new CsdElement(SERVICE_DIRECTORY);
    public static final CsdElement facilityDirectoryElement = new CsdElement(FACILITY_DIRECTORY);
    public static final CsdElement providerDirectoryElement = new CsdElement(PROVIDER_DIRECTORY);
}
