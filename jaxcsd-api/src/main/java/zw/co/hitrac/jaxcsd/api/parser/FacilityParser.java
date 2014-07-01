package zw.co.hitrac.jaxcsd.api.parser;

import zw.co.hitrac.jaxcsd.api.parser.util.HandlerUtils;
import zw.co.hitrac.jaxcsd.api.parser.ext.DefaultFacilityExtensionParser;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;
import zw.co.hitrac.jaxcsd.api.domain.Facility;
import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganizations;
import zw.co.hitrac.jaxcsd.api.domain.Geocode;
import zw.co.hitrac.jaxcsd.api.domain.OperatingHours;
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
public class FacilityParser extends AbstractCsdParser<Facility> {

    private AddressParser addressParser=new AddressParser();
    private FacilityExtensionParser facilityExtensionParser= new DefaultFacilityExtensionParser();
    private OrganizationContactParser organizationContactParser=new OrganizationContactParser();
    private GeocodeParser geocodeParser=new GeocodeParser();
    private ContactPointParser contactPointParser=new ContactPointParser();
    private FacilityOrganizationsParser facilityOrganizationsParser=new FacilityOrganizationsParser();
    private OperatingHoursParser operatingHoursParser=new OperatingHoursParser();
    
    
    public void parse(Facility facility, CsdElement facilityEement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {

        while (r.hasNext()) {
            r.next();

            if (r.isStartElement()) {
                if ("otherID".equals(r.getLocalName())) {
                    OtherID otherID = HandlerUtils.getOtherID(r);
                    facility.getOtherIDs().add(otherID);
                } else if ("codedType".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    facility.getCodedTypes().add(codedType);
                } else if ("primaryName".equals(r.getLocalName())) {
                    facility.setPrimaryName(HandlerUtils.getCharacters(r));
                } else if ("otherName".equals(r.getLocalName())) {
                    AbstractOrganization.OrganizationOtherName otherName = HandlerUtils.getOtherName(r);
                    facility.getOtherNames().add(otherName);
                } else if (ADDRESS_ELEMENT.elementEquals(r)) {
                    Address address = new Address();
                    address.setType(r.getAttributeValue("", "type"));
                    facility.getAddresses().add(address);
                    addressParser.parse(address,ADDRESS_ELEMENT, r, csdParserExtensions);
                } else if (CONTACT_ELEMENT.elementEquals(r)) {
                    AbstractOrganization.OrganizationContact contact = new AbstractOrganization.OrganizationContact();
                    facility.getContacts().add(contact);
                    organizationContactParser.parse(contact, CONTACT_ELEMENT, r, csdParserExtensions);
                } else if (GEOCODE_ELEMENT.elementEquals(r)) {
                    Geocode geocode = new Geocode();
                    facility.setGeocode(geocode);
                    geocodeParser.parse(geocode, GEOCODE_ELEMENT, r, csdParserExtensions);
                } else if ("language".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    facility.getLanguages().add(codedType);
                } else if (CONTACT_POINT_ELEMENT.elementEquals(r)) {
                    ContactPoint contactPoint = new ContactPoint();
                    facility.getContactPoints().add(contactPoint);
                    contactPointParser.parse(contactPoint, CONTACT_POINT_ELEMENT, r, csdParserExtensions);
                } else if (ORGANIZATIONS_ELEMENT.elementEquals(r)) {
                    FacilityOrganizations facilityOrganizations = new FacilityOrganizations();
                    facility.setFacilityOrganizations(facilityOrganizations);
                    facilityOrganizationsParser.parse(facilityOrganizations,ORGANIZATIONS_ELEMENT, r, csdParserExtensions);
                } else if (OPERATING_HOURS_ELEMENT.elementEquals(r)) {
                    OperatingHours operatingHours = new OperatingHours();
                    facility.getOperatingHours().add(operatingHours);
                    operatingHoursParser.parse(operatingHours, OPERATING_HOURS_ELEMENT, r, csdParserExtensions);
                } else if (extensionElement.elementEquals(r)) {
                    if (csdParserExtensions != null && csdParserExtensions.getFacilityExtensionParser() != null) {
                        csdParserExtensions.getFacilityExtensionParser().parse(facility, extensionElement, r, csdParserExtensions);
                    } else {
                        this.facilityExtensionParser.parse(facility, extensionElement, r, csdParserExtensions);
                    }
                } else if (recordElement.elementEquals(r)) {
                    Record record = HandlerUtils.getRecord(r);
                    facility.setRecord(record);
                }



            } else if (r.isEndElement()) {
                if (facilityEement.elementEquals(r)) {
                    break;
                }
            }
        }
    }

    
    public void setAddressParser(AddressParser addressParser) {
        this.addressParser = addressParser;
    }

    public void setFacilityExtensionParser(FacilityExtensionParser facilityExtensionParser) {
        this.facilityExtensionParser = facilityExtensionParser;
    }


    public void setOrganizationContactParser(OrganizationContactParser organizationContactParser) {
        this.organizationContactParser = organizationContactParser;
    }

    public void setGeocodeParser(GeocodeParser geocodeParser) {
        this.geocodeParser = geocodeParser;
    }

    public void setContactPointParser(ContactPointParser contactPointParser) {
        this.contactPointParser = contactPointParser;
    }

    public void setFacilityOrganizationsParser(FacilityOrganizationsParser facilityOrganizationsParser) {
        this.facilityOrganizationsParser = facilityOrganizationsParser;
    }

    public void setOperatingHoursParser(OperatingHoursParser operatingHoursParser) {
        this.operatingHoursParser = operatingHoursParser;
    }
    
    public static final CsdElement ADDRESS_ELEMENT=new CsdElement(CsdElementConstants.ADDRESS);
    public static final CsdElement CONTACT_ELEMENT=new CsdElement(CsdElementConstants.CONTACT);
    public static final CsdElement GEOCODE_ELEMENT=new CsdElement(CsdElementConstants.GEOCODE);
    public static final CsdElement CONTACT_POINT_ELEMENT=new CsdElement(CsdElementConstants.CONTACT_POINT);
    public static final CsdElement ORGANIZATIONS_ELEMENT=new CsdElement(CsdElementConstants.ORGANIZATIONS);
    public static final CsdElement OPERATING_HOURS_ELEMENT=new CsdElement(CsdElementConstants.OPERATING_HOURS);
    
    
}
