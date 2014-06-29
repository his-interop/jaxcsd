package zw.co.hitrac.jaxcsd.api.marshal;

import java.math.BigDecimal;
import java.util.Date;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.Facility;
import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganization;
import zw.co.hitrac.jaxcsd.api.domain.Geocode;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityMarshaler extends Marshaler<Facility> {

    private static final FacilityMarshaler INSTANCE = new FacilityMarshaler();

    private FacilityMarshaler() {
    }

    @Override
    public String marshal(Facility facility, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(" oid=\"").append(facility.getOid()).append("\">");
        sb.append(OtherIDListMarshaler.get().marshal(facility.getOtherIDs()));
        sb.append(CodedTypeListMarshaler.get().marshal(facility.getCodedTypes(), "codedType"));
        sb.append(getInlineXmlElement("primaryName", facility.getPrimaryName()));
        sb.append(OrganizationOtherNameListMarshaler.get().marshal(facility.getOtherNames()));
        sb.append(AddressListMarshaler.get().marshal(facility.getAddresses()));
        sb.append(OrganizationContactListMarshaler.get().marshal(facility.getContacts()));
        sb.append(GeocodeMarshaler.get().marshal(facility.getGeocode()));
        sb.append(CodedTypeListMarshaler.get().marshal(facility.getLanguages(), "language"));
        sb.append(ContactPointListMarshaler.get().marshal(facility.getContactPoints()));
        sb.append(FacilityOrganizationsMarshaler.get().marshal(facility.getFacilityOrganizations()));
        //TODO: OperatingHoursMarshaller here!!
        sb.append(ExtensionListMarshaller.get().marshal(facility.getExtensions()));
        sb.append(RecordMarshaler.get().marshal(facility.getRecord()));
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    @Override
    public String marshal(Facility facility) {
        return marshal(facility, FACILITY);
    }

    public static FacilityMarshaler get() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Facility facility = new Facility();
        facility.setOid("1.3.6.1.4.1.21367.200.99.11");
        facility.addCodedType("103-110", "1.3.6.1.4.1.21367.100.1", "Radiology - Imaging Services");
        facility.setPrimaryName("Connectathon Radiology Facility");
        facility.addAddress(new Address("Billing")
                .addAddressLine("streetAddress", "1234 Cactus Way")
                .addAddressLine("city", "Santa Fe")
                .addAddressLine("stateProvince", "NM")
                .addAddressLine("country", "USA")
                .addAddressLine("postalCode", "87501"));

        facility.addFacilityOrganization(new FacilityOrganization("1.3.6.1.4.1.21367.200.99.1"));

        facility.setGeocode(new Geocode(new BigDecimal("35.05"), new BigDecimal("106.60")));
        facility.setRecord(new Record(new Date(), new Date(), "Active"));
        System.out.println(facility.marshal());
    }
}
