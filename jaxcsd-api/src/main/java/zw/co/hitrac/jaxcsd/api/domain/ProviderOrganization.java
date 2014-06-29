package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.ProviderOrganizationMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderOrganization extends UniqueID{
    
    private List<Extension> extensions=new ArrayList<Extension>();
    private List<Address> addresses=new ArrayList<Address>();
    private List<ContactPoint> contactPoints=new ArrayList<ContactPoint>();

    public ProviderOrganization() {
    }

    public ProviderOrganization(String oid) {
        super(oid);
    }

    public List<Extension> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<Extension> extensions) {
        this.extensions = extensions;
    }
    
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<ContactPoint> getContactPoints() {
        return contactPoints;
    }

    public void setContactPoints(List<ContactPoint> contactPoints) {
        this.contactPoints = contactPoints;
    }

    public String marshal() {
     return ProviderOrganizationMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
        return ProviderOrganizationMarshaler.get().marshal(this, elementName);
    }
    
    
}
