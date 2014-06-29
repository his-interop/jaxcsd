package zw.co.hitrac.jaxcsd.api.parser;

import zw.co.hitrac.jaxcsd.api.xp.*;
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
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityParser extends AbstractCsdParser<Facility>{
    
    private DefaultFacilityExtensionParser defaultFacilityExtensionParser=new DefaultFacilityExtensionParser();

    public  void parse(Facility facility, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {

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
                } else if ("address".equals(r.getLocalName())) {
                    Address address = new Address();
                    address.setType(r.getAttributeValue("", "type"));
                    facility.getAddresses().add(address);
                    AddressHandler.handle(address, r);
                } else if ("contact".equals(r.getLocalName())) {
                    AbstractOrganization.OrganizationContact contact = new AbstractOrganization.OrganizationContact();
                    facility.getContacts().add(contact);
                    OrganizationContactHandler.handle(contact, r);
                } else if ("geocode".equals(r.getLocalName())) {
                    Geocode geocode = new Geocode();
                    facility.setGeocode(geocode);
                    GeocodeHandler.handle(geocode, r);
                } else if ("language".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    facility.getLanguages().add(codedType);
                } else if ("contactPoint".equals(r.getLocalName())) {
                    ContactPoint contactPoint = new ContactPoint();
                    facility.getContactPoints().add(contactPoint);
                    ContactPointHandler.handle(contactPoint, r);
                } else if ("organizations".equals(r.getLocalName())) {
                    FacilityOrganizations facilityOrganizations = new FacilityOrganizations();
                    facility.setFacilityOrganizations(facilityOrganizations);
                    FacilityOrganizationsHandler.handle(facilityOrganizations, r);
                } else if ("operatingHours".equals(r.getLocalName())) {
                    OperatingHours operatingHours=new OperatingHours();
                    facility.getOperatingHours().add(operatingHours);
                    OperatingHoursHandler.handle(operatingHours, r);
                }else if ("extension".equals(r.getLocalName())) {
                    if(csdParserExtensions!=null && csdParserExtensions.getFacilityExtensionParser()!=null){
                        csdParserExtensions.getFacilityExtensionParser().parse(facility, r, csdParserExtensions);
                    }else{
                        this.defaultFacilityExtensionParser.parse(facility, r, csdParserExtensions);
                    }                   
                } else if ("record".equals(r.getLocalName())) {
                    Record record = HandlerUtils.getRecord(r);
                    facility.setRecord(record);
                }



            } else if (r.isEndElement()) {
                if ("facility".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }

    public void setDefaultFacilityExtensionParser(DefaultFacilityExtensionParser defaultFacilityExtensionParser) {
        this.defaultFacilityExtensionParser = defaultFacilityExtensionParser;
    }
    
    
}
