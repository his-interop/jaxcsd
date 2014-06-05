package zw.co.hitrac.jaxcsd.api.xp;

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
import zw.co.hitrac.jaxcsd.api.domain.ext.OrganizationExtension;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationHandler {

    public static void handle(Organization organization, XMLStreamReader r) throws XMLStreamException {

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
                } else if ("address".equals(r.getLocalName())) {
                    Address address = new Address();
                    address.setType(r.getAttributeValue("", "type"));
                    organization.getAddresses().add(address);
                    AddressHandler.handle(address, r);
                } else if ("contact".equals(r.getLocalName())) {
                    AbstractOrganization.OrganizationContact contact = new AbstractOrganization.OrganizationContact();
                    organization.getContacts().add(contact);
                    OrganizationContactHandler.handle(contact, r);
                } else if ("credential".equals(r.getLocalName())) {
                    Credential credential = HandlerUtils.getCredential(r);
                    organization.getCredentials().add(credential);
                } else if ("language".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    organization.getLanguages().add(codedType);
                } else if ("specialization".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    organization.getSpecializations().add(codedType);
                } else if ("contactPoint".equals(r.getLocalName())) {
                    ContactPoint contactPoint = new ContactPoint();
                    organization.getContactPoints().add(contactPoint);
                    ContactPointHandler.handle(contactPoint, r);
                } else if("parent".equals(r.getLocalName())){
                    Organization parent=new Organization(r.getAttributeValue("", "oid"));
                    organization.setParent(parent);
                } else if ("extension".equals(r.getLocalName())) {
                    OrganizationExtension organizationExtension = new OrganizationExtension();
                    organization.getExtensions().add(organizationExtension);
                    ExtensionHandler.handle(organizationExtension, r);
                } else if ("record".equals(r.getLocalName())) {
                    Record record = HandlerUtils.getRecord(r);
                    organization.setRecord(record);
                }



            } else if (r.isEndElement()) {
                if ("organization".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
}
