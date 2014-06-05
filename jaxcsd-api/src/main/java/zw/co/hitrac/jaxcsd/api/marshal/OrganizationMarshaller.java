package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.Date;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.Name;
import zw.co.hitrac.jaxcsd.api.domain.Organization;
import zw.co.hitrac.jaxcsd.api.domain.Person;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import zw.co.hitrac.jaxcsd.api.marshal.ext.ExtensionListMarshaller;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationMarshaller extends Marshaller<Organization>{
    
    
    private static final OrganizationMarshaller INSTANCE=new OrganizationMarshaller();

    private OrganizationMarshaller() {
    }
    
    public String marshal(Organization organization){
       StringBuilder sb=new StringBuilder();
       sb.append("<organization oid=\"").append(organization.getOid()).append("\">");
       sb.append(OtherIDListMarshaller.get().marshal(organization.getOtherIDs()));
       sb.append(CodedTypeListMarshaller.get().marshal(organization.getCodedTypes(),"codedType"));
       sb.append(getInlineXmlElement("primaryName", organization.getPrimaryName()));
       sb.append(OrganizationOtherNameListMarshaller.get().marshal(organization.getOtherNames()));
       sb.append(AddressListMarshaller.get().marshal(organization.getAddresses()));
       sb.append(OrganizationContactListMarshaller.get().marshal(organization.getContacts()));
       sb.append(CredentialListMarshaller.get().marshal(organization.getCredentials()));
       sb.append(CodedTypeListMarshaller.get().marshal(organization.getLanguages(),"language"));
       sb.append(CodedTypeListMarshaller.get().marshal(organization.getSpecializations(),"specialization"));
       sb.append(ContactPointListMarshaller.get().marshal(organization.getContactPoints()));
       sb.append(UniqueIDMarshaller.get().marshal(organization.getParent()));
       sb.append(ExtensionListMarshaller.get().marshal(organization.getExtensions()));
       sb.append(RecordMarshaller.get().marshal(organization.getRecord()));
       sb.append("</organization>");
       return sb.toString();
       
    }

    public static OrganizationMarshaller get() {
        return INSTANCE;
    }
    
    
    public static void main(String[] args){
        Organization organization=new Organization();
        organization.setOid("1.3.6.1.4.1.21367.200.99.1");
        organization.addCodedType("101-002", "1.3.6.1.4.1.21367.100.1", "Integrated Delivery Network");
        organization.setPrimaryName("Connectathon CSD IDN One");
        organization.addAddress(new Address("Billing")
                .addAddressLine("streetAddress", "1234 Cactus Way")
                .addAddressLine("city", "Santa Fe")
                .addAddressLine("stateProvince", "NM")
                .addAddressLine("country", "USA")
                .addAddressLine("postalCode", "87501")
                );
        
        organization.addAddress(new Address("Mailing")
                .addAddressLine("streetAddress", "7890 Forest Road")
                .addAddressLine("city", "Santa Fe")
                .addAddressLine("stateProvince", "NM")
                .addAddressLine("country", "USA")
                .addAddressLine("postalCode", "87505")
                );
        
        
        Person contactPerson=new Person();
        Name name=new Name(null, "Contact", "Connie").addCommonName("Contact, Connie");
        contactPerson.addName(name);
        contactPerson.addAddress(new Address()
                .addAddressLine("StreetAddress", "7890 Forest Road")
                .addAddressLine("City", "Santa Fe")
                .addAddressLine("Country", "NM")
                .addAddressLine("PostCode", "87505")
                );
        organization.addContactPerson(contactPerson);
        organization.setRecord(new Record(new Date(), new Date(), "Active"));
        System.out.println(organization.marshal());
    
    }
    
    
}
