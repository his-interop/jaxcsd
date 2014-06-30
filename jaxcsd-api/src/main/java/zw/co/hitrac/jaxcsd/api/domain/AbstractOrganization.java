package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;
import zw.co.hitrac.jaxcsd.api.marshal.OrganizationContactMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.OrganizationOtherNameMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class AbstractOrganization extends CsdEntity {

    protected List<OtherID> otherIDs = new ArrayList<OtherID>();
    protected String primaryName;
    protected List<OrganizationOtherName> otherNames = new ArrayList<OrganizationOtherName>();
    protected List<Address> addresses = new ArrayList<Address>();
    protected List<OrganizationContact> contacts = new ArrayList<OrganizationContact>();
    protected List<ContactPoint> contactPoints = new ArrayList<ContactPoint>();
    protected List<CodedType> languages = new ArrayList<CodedType>();
    

    public List<OtherID> getOtherIDs() {
        return otherIDs;
    }

    public void setOtherIDs(List<OtherID> otherIDs) {
        this.otherIDs = otherIDs;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public List<OrganizationOtherName> getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List<OrganizationOtherName> otherNames) {
        this.otherNames = otherNames;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<OrganizationContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<OrganizationContact> contacts) {
        this.contacts = contacts;
    }

    public List<ContactPoint> getContactPoints() {
        return contactPoints;
    }

    public void setContactPoints(List<ContactPoint> contactPoints) {
        this.contactPoints = contactPoints;
    }

    public List<CodedType> getLanguages() {
        return languages;
    }

    public void setLanguages(List<CodedType> languages) {
        this.languages = languages;
    }

    public AbstractOrganization addAddress(Address address) {
        this.addresses.add(address);
        return this;
    }

    public AbstractOrganization addContactPerson(Person person) {
        OrganizationContact contact = new OrganizationContact();
        contact.setPerson(person);
        this.contacts.add(contact);
        return this;
    }

    public AbstractOrganization addLanguage(String code, String codingSchema, String value) {
        this.languages.add(new CodedType(code, codingSchema, value));
        return this;
    }

    public AbstractOrganization addContactPoint(ContactPoint contactPoint) {
        this.contactPoints.add(contactPoint);
        return this;
    }

    public static class OrganizationOtherName implements CsdMarshalable {

        private String value;
        private String lang;
        private Marshaler<OrganizationOtherName> marshaler = OrganizationOtherNameMarshaler.get();

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public Marshaler<OrganizationOtherName> getMarshaler() {
            return marshaler;
        }

        public void setMarshaler(Marshaler<OrganizationOtherName> marshaler) {
            this.marshaler = marshaler;
        }

        public String marshal() {
            return marshaler.marshal(this);
        }

        public String marshal(String elementName) {
            return marshaler.marshal(this, elementName);
        }
    }

    public static class OrganizationContact implements CsdMarshalable {

        private UniqueID provider;
        private Person person;
        private Marshaler<OrganizationContact> marshaler = OrganizationContactMarshaler.get();

        public UniqueID getProvider() {
            return provider;
        }

        public void setProvider(UniqueID provider) {
            this.provider = provider;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public Marshaler<OrganizationContact> getMarshaler() {
            return marshaler;
        }

        public void setMarshaler(Marshaler<OrganizationContact> marshaler) {
            this.marshaler = marshaler;
        }

        public String marshal() {
            return marshaler.marshal(this);
        }

        public String marshal(String elementName) {
            return marshaler.marshal(this, elementName);
        }
    }
}
