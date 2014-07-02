package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;
import zw.co.hitrac.jaxcsd.api.marshal.ProviderMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Provider extends CsdEntity {

    private List<OtherID> otherIDs = new ArrayList<OtherID>();
    private Person demographic = new Person();
    private List<CodedType> languages = new ArrayList<CodedType>();
    private ProviderOrganizations providerOrganizations;
    private ProviderFacilities providerFacilities;
    private List<Credential> credentials = new ArrayList<Credential>();
    private List<CodedType> specialties = new ArrayList<CodedType>();
    private Marshaler<Provider> marshaler = ProviderMarshaler.get();

    public Provider() {
    }

    public Provider(String oid) {
        this.oid = oid;
    }

    public Person getDemographic() {
        return demographic;
    }

    public void setDemographic(Person demographic) {
        this.demographic = demographic;
    }

    public List<CodedType> getLanguages() {
        return languages;
    }

    public void setLanguages(List<CodedType> languages) {
        this.languages = languages;
    }

    public List<OtherID> getOtherIDs() {
        return otherIDs;
    }

    public void setOtherIDs(List<OtherID> otherIDs) {
        this.otherIDs = otherIDs;
    }

    public List<Credential> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<Credential> credentials) {
        this.credentials = credentials;
    }

    public ProviderOrganizations getProviderOrganizations() {
        return providerOrganizations;
    }

    public void setProviderOrganizations(ProviderOrganizations providerOrganizations) {
        this.providerOrganizations = providerOrganizations;
    }

    public ProviderFacilities getProviderFacilities() {
        return providerFacilities;
    }

    public void setProviderFacilities(ProviderFacilities providerFacilities) {
        this.providerFacilities = providerFacilities;
    }

    public List<CodedType> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<CodedType> specialties) {
        this.specialties = specialties;
    }

    public Marshaler<Provider> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<Provider> marshaler) {
        this.marshaler = marshaler;
    }

    public Provider addOtherID(String code, String assigningAuthorityName) {
        OtherID otherID = new OtherID();
        otherID.setCode(code);
        otherID.setAssigningAuthorityName(assigningAuthorityName);
        this.otherIDs.add(otherID);
        return this;
    }

    public Provider addLanguage(String code, String codingScheme, String value) {
        this.languages.add(new CodedType(code, codingScheme, value));
        return this;
    }

    public Provider addProviderOrganization(ProviderOrganization providerOrganization) {
        if (providerOrganizations == null) {
            providerOrganizations = new ProviderOrganizations();
        }
        providerOrganizations.addProviderOrganization(providerOrganization);
        return this;
    }

    public Provider addProviderFacility(ProviderFacility providerFacility) {
        if (providerFacilities == null) {
            providerFacilities = new ProviderFacilities();
        }
        providerFacilities.addProviderFacility(providerFacility);
        return this;
    }

    public Provider addCredential(Credential credential) {
        this.credentials.add(credential);
        return this;
    }

    public Provider addSpecialty(String code, String codingScheme, String value) {
        this.specialties.add(new CodedType(code, codingScheme, value));
        return this;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public Name getTopName() {
        if (demographic != null && demographic.getNames() != null && !demographic.getNames().isEmpty()) {
            return demographic.getNames().get(0);
        } else {
            return null;
        }
    }
}
