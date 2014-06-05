package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.OrganizationDirectoryMarshaller;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationDirectory implements CsdMarshallable {

    private List<Organization> organizations = new ArrayList<Organization>();

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
    
    public OrganizationDirectory addOrganization(Organization organization){
        this.organizations.add(organization);
        return this;
    }

    public String marshal() {
        return OrganizationDirectoryMarshaller.get().marshal(this);
    }
}
