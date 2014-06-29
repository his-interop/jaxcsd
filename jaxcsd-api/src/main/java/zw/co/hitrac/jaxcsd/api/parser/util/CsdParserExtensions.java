package zw.co.hitrac.jaxcsd.api.parser.util;

import zw.co.hitrac.jaxcsd.api.parser.FacilityExtensionParser;
import zw.co.hitrac.jaxcsd.api.parser.OrganizationExtensionParser;
import zw.co.hitrac.jaxcsd.api.parser.ProviderExtensionParser;
import zw.co.hitrac.jaxcsd.api.parser.ServiceExtensionParser;

/**
 *
 * @author Charles Chigoriwa
 */
public class CsdParserExtensions {
    
    private ProviderExtensionParser providerExtensionParser;
    private OrganizationExtensionParser organizationExtensionParser;
    private FacilityExtensionParser facilityExtensionParser;
    private ServiceExtensionParser serviceExtensionParser;

    public ProviderExtensionParser getProviderExtensionParser() {
        return providerExtensionParser;
    }

    public void setProviderExtensionParser(ProviderExtensionParser providerExtensionParser) {
        this.providerExtensionParser = providerExtensionParser;
    }

    public OrganizationExtensionParser getOrganizationExtensionParser() {
        return organizationExtensionParser;
    }

    public void setOrganizationExtensionParser(OrganizationExtensionParser organizationExtensionParser) {
        this.organizationExtensionParser = organizationExtensionParser;
    }

    public FacilityExtensionParser getFacilityExtensionParser() {
        return facilityExtensionParser;
    }

    public void setFacilityExtensionParser(FacilityExtensionParser facilityExtensionParser) {
        this.facilityExtensionParser = facilityExtensionParser;
    }

    public ServiceExtensionParser getServiceExtensionParser() {
        return serviceExtensionParser;
    }

    public void setServiceExtensionParser(ServiceExtensionParser serviceExtensionParser) {
        this.serviceExtensionParser = serviceExtensionParser;
    }
    
    
    
}
