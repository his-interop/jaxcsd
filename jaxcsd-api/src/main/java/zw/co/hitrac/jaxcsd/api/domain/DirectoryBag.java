package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Charles Chigoriwa
 */
public class DirectoryBag implements Serializable {

    private List<Organization> organizations;
    private List<Provider> providers;
    private List<Service> services;
    private List<Facility> facilities;

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
    
    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
    
    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }
}
