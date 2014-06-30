package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.FacilityOrganizationMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganization extends UniqueID {

    private List<FacilityOrganizationService> services = new ArrayList<FacilityOrganizationService>();
    private List<Extension> extensions = new ArrayList<Extension>();
    private Marshaler<FacilityOrganization> marshaler = FacilityOrganizationMarshaler.get();

    public FacilityOrganization() {
    }

    public FacilityOrganization(String oid) {
        super(oid);
    }

    public List<FacilityOrganizationService> getServices() {
        return services;
    }

    public void setServices(List<FacilityOrganizationService> services) {
        this.services = services;
    }

    public List<Extension> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<Extension> extensions) {
        this.extensions = extensions;
    }

    public FacilityOrganization addExtension(Extension extension) {
        this.extensions.add(extension);
        return this;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public Marshaler<FacilityOrganization> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<FacilityOrganization> marshaler) {
        this.marshaler = marshaler;
    }

    public static class FacilityOrganizationService extends UniqueID {

        private List<Name> names = new ArrayList<Name>();
        private List<CodedType> languages = new ArrayList<CodedType>();
        private List<OperatingHours> operatingHours = new ArrayList<OperatingHours>();
        private String freeBusyURI;

        public List<Name> getNames() {
            return names;
        }

        public void setNames(List<Name> names) {
            this.names = names;
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

        public String marshal() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public String marshal(String elementName) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
