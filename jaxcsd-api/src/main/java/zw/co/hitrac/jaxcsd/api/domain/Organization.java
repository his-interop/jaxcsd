package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;
import zw.co.hitrac.jaxcsd.api.marshal.OrganizationMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Organization extends AbstractOrganization {

    private List<Credential> credentials = new ArrayList<Credential>();
    private UniqueID parent;
    private List<CodedType> specializations = new ArrayList<CodedType>();
    private Marshaler<Organization> marshaler = OrganizationMarshaler.get();

    public Organization() {
    }

    public Organization(String entityID) {
        this.entityID=entityID;
    }

    public List<Credential> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<Credential> credentials) {
        this.credentials = credentials;
    }

    public UniqueID getParent() {
        return parent;
    }

    public void setParent(UniqueID parent) {
        this.parent = parent;
    }

    public List<CodedType> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<CodedType> specializations) {
        this.specializations = specializations;
    }

    public Organization addCredential(Credential credential) {
        this.credentials.add(credential);
        return this;
    }

    public String marshal() {
        return OrganizationMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public Marshaler<Organization> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<Organization> marshaler) {
        this.marshaler = marshaler;
    }
}
