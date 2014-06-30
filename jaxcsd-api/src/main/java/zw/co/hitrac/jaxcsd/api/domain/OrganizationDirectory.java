package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;
import zw.co.hitrac.jaxcsd.api.marshal.OrganizationDirectoryMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationDirectory implements CsdMarshalable {

    private List<Organization> organizations = new ArrayList<Organization>();
    private Marshaler<OrganizationDirectory> marshaler = OrganizationDirectoryMarshaler.get();

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public OrganizationDirectory addOrganization(Organization organization) {
        this.organizations.add(organization);
        return this;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public Marshaler<OrganizationDirectory> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<OrganizationDirectory> marshaler) {
        this.marshaler = marshaler;
    }

    public boolean isEmpty() {
        return organizations == null || organizations.isEmpty();
    }
}
