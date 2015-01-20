package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.Date;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.Name;
import zw.co.hitrac.jaxcsd.api.domain.Organization;
import zw.co.hitrac.jaxcsd.api.domain.Person;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationMarshaler extends Marshaler<Organization> {

    private static final OrganizationMarshaler INSTANCE = new OrganizationMarshaler();

    private OrganizationMarshaler() {
    }

    @Override
    public String marshal(Organization organization, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(" entityID=\"").append(organization.getEntityID()).append("\">");
        sb.append(OtherIDListMarshaler.get().marshal(organization.getOtherIDs()));
        sb.append(CodedTypeListMarshaler.get().marshal(organization.getCodedTypes(), "codedType"));
        sb.append(getInlineXmlElement("primaryName", organization.getPrimaryName()));
        sb.append(OrganizationOtherNameListMarshaler.get().marshal(organization.getOtherNames()));
        sb.append(AddressListMarshaler.get().marshal(organization.getAddresses()));
        sb.append(OrganizationContactListMarshaler.get().marshal(organization.getContacts()));
        sb.append(CredentialListMarshaler.get().marshal(organization.getCredentials()));
        sb.append(CodedTypeListMarshaler.get().marshal(organization.getLanguages(), "language"));
        sb.append(CodedTypeListMarshaler.get().marshal(organization.getSpecializations(), "specialization"));
        sb.append(ContactPointListMarshaler.get().marshal(organization.getContactPoints()));
        sb.append(UniqueIDMarshaler.get().marshal(organization.getParent()));
        sb.append(ExtensionListMarshaller.get().marshal(organization.getExtensions()));
        sb.append(RecordMarshaler.get().marshal(organization.getRecord()));
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    public String marshal(Organization organization) {
        return marshal(organization, ORGANIZATION);
    }

    public static OrganizationMarshaler get() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Organization organization = new Organization();
        organization.setEntityID("urn:oid:1.3.6.1.4.1.21367.200.99.1");
        organization.addCodedType("101-002", "1.3.6.1.4.1.21367.100.1", "Integrated Delivery Network");
        organization.setPrimaryName("Connectathon CSD IDN One");
        organization.addAddress(new Address("Billing")
                .addAddressLine("streetAddress", "1234 Cactus Way")
                .addAddressLine("city", "Santa Fe")
                .addAddressLine("stateProvince", "NM")
                .addAddressLine("country", "USA")
                .addAddressLine("postalCode", "87501"));

        organization.addAddress(new Address("Mailing")
                .addAddressLine("streetAddress", "7890 Forest Road")
                .addAddressLine("city", "Santa Fe")
                .addAddressLine("stateProvince", "NM")
                .addAddressLine("country", "USA")
                .addAddressLine("postalCode", "87505"));


        Person contactPerson = new Person();
        Name name = new Name(null, "Contact", "Connie").addCommonName("Contact, Connie");
        contactPerson.addName(name);
        contactPerson.addAddress(new Address()
                .addAddressLine("StreetAddress", "7890 Forest Road")
                .addAddressLine("City", "Santa Fe")
                .addAddressLine("Country", "NM")
                .addAddressLine("PostCode", "87505"));
        organization.addContactPerson(contactPerson);
        organization.setRecord(new Record(new Date(), new Date(), "Active"));
        System.out.println(organization.marshal());

    }
}
