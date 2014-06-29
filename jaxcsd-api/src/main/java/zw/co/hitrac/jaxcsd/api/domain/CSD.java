package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.CsdMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class CSD implements CsdMarshalable {

    private OrganizationDirectory organizationDirectory;
    private ServiceDirectory serviceDirectory;
    private FacilityDirectory facilityDirectory;
    private ProviderDirectory providerDirectory;
    
    private Marshaler<CSD> marshaler=CsdMarshaler.get();

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public ServiceDirectory getServiceDirectory() {
        return serviceDirectory;
    }

    public void setServiceDirectory(ServiceDirectory serviceDirectory) {
        this.serviceDirectory = serviceDirectory;
    }

    public FacilityDirectory getFacilityDirectory() {
        return facilityDirectory;
    }

    public void setFacilityDirectory(FacilityDirectory facilityDirectory) {
        this.facilityDirectory = facilityDirectory;
    }

    public ProviderDirectory getProviderDirectory() {
        return providerDirectory;
    }

    public void setProviderDirectory(ProviderDirectory providerDirectory) {
        this.providerDirectory = providerDirectory;
    }

    public CSD addOrganization(Organization organization) {
        if (organizationDirectory == null) {
            organizationDirectory = new OrganizationDirectory();
        }
        organizationDirectory.addOrganization(organization);
        return this;
    }

    public CSD addService(Service service) {
        if (serviceDirectory == null) {
            serviceDirectory = new ServiceDirectory();
        }
        serviceDirectory.addService(service);
        return this;
    }

    public CSD addFacility(Facility facility) {
        if (facilityDirectory == null) {
            facilityDirectory = new FacilityDirectory();
        }
        facilityDirectory.addFacility(facility);
        return this;
    }

    public CSD addProvider(Provider provider) {
        if (providerDirectory == null) {
            providerDirectory = new ProviderDirectory();
        }
        providerDirectory.addProvider(provider);
        return this;
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    @Override
    public String toString() {
        return marshal();
    }

    public Marshaler<CSD> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<CSD> marshaler) {
        this.marshaler = marshaler;
    }
    
    
    
}
