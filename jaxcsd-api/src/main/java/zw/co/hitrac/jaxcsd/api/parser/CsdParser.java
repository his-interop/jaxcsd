package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CSD;
import zw.co.hitrac.jaxcsd.api.domain.FacilityDirectory;
import zw.co.hitrac.jaxcsd.api.domain.OrganizationDirectory;
import zw.co.hitrac.jaxcsd.api.domain.ProviderDirectory;
import zw.co.hitrac.jaxcsd.api.domain.ServiceDirectory;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

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
    public void parse(final CSD csd, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {

        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                String localName = r.getLocalName();
                if ("organizationDirectory".equals(localName)) {
                    if (csd != null) {
                        csd.setOrganizationDirectory(new OrganizationDirectory());
                        organizationDirectoryParser.parse(csd.getOrganizationDirectory(), r, csdParserExtensions);
                    }
                } else if ("serviceDirectory".equals(localName)) {
                    if (csd != null) {
                        csd.setServiceDirectory(new ServiceDirectory());
                        serviceDirectoryParser.parse(csd.getServiceDirectory(), r, csdParserExtensions);
                    }
                } else if ("facilityDirectory".equals(localName)) {
                    if (csd != null) {
                        csd.setFacilityDirectory(new FacilityDirectory());
                        facilityDirectoryParser.parse(csd.getFacilityDirectory(), r, csdParserExtensions);
                    }
                } else if ("providerDirectory".equals(localName)) {
                    if (csd != null) {
                        csd.setProviderDirectory(new ProviderDirectory());
                        providerDirectoryParser.parse(csd.getProviderDirectory(), r, csdParserExtensions);
                    }
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
}
