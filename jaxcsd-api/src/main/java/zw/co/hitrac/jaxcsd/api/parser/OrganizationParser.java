package zw.co.hitrac.jaxcsd.api.parser;

import zw.co.hitrac.jaxcsd.api.parser.util.HandlerUtils;
import zw.co.hitrac.jaxcsd.api.parser.ext.DefaultOrganizationExtensionParser;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization.OrganizationOtherName;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import zw.co.hitrac.jaxcsd.api.domain.Organization;
import zw.co.hitrac.jaxcsd.api.domain.OtherID;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import static zw.co.hitrac.jaxcsd.api.parser.AbstractCsdParser.extensionElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationParser extends AbstractCsdParser<Organization> {

    private DefaultOrganizationExtensionParser defaultOrganizationExtensionParser = new DefaultOrganizationExtensionParser();
    private AddressParser addressParser=new AddressParser();
    private OrganizationContactParser organizationContactParser=new OrganizationContactParser();
    private ContactPointParser contactPointParser=new ContactPointParser();
    
    
    public void parse(Organization organization, CsdElement organizationElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {

        while (r.hasNext()) {
            r.next();

            if (r.isStartElement()) {
                if ("otherID".equals(r.getLocalName())) {
                    OtherID otherID = HandlerUtils.getOtherID(r);
                    organization.getOtherIDs().add(otherID);
                } else if ("codedType".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    organization.getCodedTypes().add(codedType);
                } else if ("primaryName".equals(r.getLocalName())) {
                    organization.setPrimaryName(HandlerUtils.getCharacters(r));
                } else if ("otherName".equals(r.getLocalName())) {
                    OrganizationOtherName otherName = HandlerUtils.getOtherName(r);
                    organization.getOtherNames().add(otherName);
                } else if (ADDRESS_ELEMENT.elementEquals(r)) {
                    Address address = new Address();
                    address.setType(r.getAttributeValue("", "type"));
                    organization.getAddresses().add(address);
                     addressParser.parse(address,ADDRESS_ELEMENT, r, csdParserExtensions);
                } else if (CONTACT_ELEMENT.elementEquals(r)) {
                    AbstractOrganization.OrganizationContact contact = new AbstractOrganization.OrganizationContact();
                    organization.getContacts().add(contact);
                    organizationContactParser.parse(contact, CONTACT_ELEMENT, r, csdParserExtensions);
                } else if ("credential".equals(r.getLocalName())) {
                    Credential credential = HandlerUtils.getCredential(r);
                    organization.getCredentials().add(credential);
                } else if ("language".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    organization.getLanguages().add(codedType);
                } else if ("specialization".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    organization.getSpecializations().add(codedType);
                } else if (CONTACT_POINT_ELEMENT.elementEquals(r)) {
                    ContactPoint contactPoint = new ContactPoint();
                    organization.getContactPoints().add(contactPoint);
                    contactPointParser.parse(contactPoint, CONTACT_POINT_ELEMENT, r, csdParserExtensions);
                } else if ("parent".equals(r.getLocalName())) {
                    Organization parent = new Organization(r.getAttributeValue("", "entityID"));
                    organization.setParent(parent);
                } else if (extensionElement.elementEquals(r)) {
                    if (csdParserExtensions != null && csdParserExtensions.getOrganizationExtensionParser() != null) {
                        csdParserExtensions.getOrganizationExtensionParser().parse(organization, extensionElement, r, csdParserExtensions);
                    } else {
                        this.defaultOrganizationExtensionParser.parse(organization, extensionElement, r, csdParserExtensions);
                    }
                } else if (recordElement.elementEquals(r)) {
                    Record record = HandlerUtils.getRecord(r);
                    organization.setRecord(record);
                }



            } else if (r.isEndElement()) {
                if (organizationElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }

    public void setDefaultOrganizationExtensionParser(DefaultOrganizationExtensionParser defaultOrganizationExtensionParser) {
        this.defaultOrganizationExtensionParser = defaultOrganizationExtensionParser;
    }
    
     public void setAddressParser(AddressParser addressParser) {
        this.addressParser = addressParser;
    }

   
    public void setOrganizationContactParser(OrganizationContactParser organizationContactParser) {
        this.organizationContactParser = organizationContactParser;
    }


    public void setContactPointParser(ContactPointParser contactPointParser) {
        this.contactPointParser = contactPointParser;
    }

    
    
    
    public static final CsdElement ADDRESS_ELEMENT = new CsdElement(CsdElementConstants.ADDRESS);
    public static final CsdElement CONTACT_ELEMENT = new CsdElement(CsdElementConstants.CONTACT);
    public static final CsdElement GEOCODE_ELEMENT = new CsdElement(CsdElementConstants.GEOCODE);
    public static final CsdElement CONTACT_POINT_ELEMENT = new CsdElement(CsdElementConstants.CONTACT_POINT);
    public static final CsdElement ORGANIZATIONS_ELEMENT = new CsdElement(CsdElementConstants.ORGANIZATIONS);
    public static final CsdElement OPERATING_HOURS_ELEMENT = new CsdElement(CsdElementConstants.OPERATING_HOURS);
}
