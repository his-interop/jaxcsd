package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderFacility extends UniqueID{
    
    private List<ProviderFacilityService> services=new ArrayList<ProviderFacilityService>();
    private List<OperatingHours> operatingHours=new ArrayList<OperatingHours>();
    private List<Extension> extensions=new ArrayList<Extension>();

    public List<ProviderFacilityService> getServices() {
        return services;
    }

    public void setServices(List<ProviderFacilityService> services) {
        this.services = services;
    }

    public List<OperatingHours> getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(List<OperatingHours> operatingHours) {
        this.operatingHours = operatingHours;
    }

    public List<Extension> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<Extension> extensions) {
        this.extensions = extensions;
    }
    
    public ProviderFacility addExtension(Extension extension){
        this.extensions.add(extension);
        return this;
    }
    
    

    public static class ProviderFacilityService extends UniqueID{
        
        private List<Name> names=new ArrayList<Name>();
        private UniqueID organization;
        private List<CodedType> languages=new ArrayList<CodedType>();
        private List<OperatingHours> operatingHours=new ArrayList<OperatingHours>();
        private String freeBusyURI;

        public List<Name> getNames() {
            return names;
        }

        public void setNames(List<Name> names) {
            this.names = names;
        }

        public UniqueID getOrganization() {
            return organization;
        }

        public void setOrganization(UniqueID organization) {
            this.organization = organization;
        }

        public List<CodedType> getLanguages() {
            return languages;
        }

        public void setLanguages(List<CodedType> languages) {
            this.languages = languages;
        }

        public List<OperatingHours> getOperatingHours() {
            return operatingHours;
        }

        public void setOperatingHours(List<OperatingHours> operatingHours) {
            this.operatingHours = operatingHours;
        }

        public String getFreeBusyURI() {
            return freeBusyURI;
        }

        public void setFreeBusyURI(String freeBusyURI) {
            this.freeBusyURI = freeBusyURI;
        }
        
        
        
        
        
    }
    
}
