package zw.co.hitrac.jaxcsd.api.parser;

import zw.co.hitrac.jaxcsd.api.xp.*;
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

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationParser extends AbstractCsdParser<Organization>{
    
    private DefaultOrganizationExtensionParser defaultOrganizationExtensionParser=new DefaultOrganizationExtensionParser();

    public void parse(Organization organization,CsdElement organizationElement,  XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {

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
                } else if (extensionElement.elementEquals(r)) {
                    if(csdParserExtensions!=null && csdParserExtensions.getOrganizationExtensionParser()!=null){
                        csdParserExtensions.getOrganizationExtensionParser().parse(organization,extensionElement, r, csdParserExtensions);
                    }else{
                        this.defaultOrganizationExtensionParser.parse(organization,extensionElement, r, csdParserExtensions);
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
    
    
}
