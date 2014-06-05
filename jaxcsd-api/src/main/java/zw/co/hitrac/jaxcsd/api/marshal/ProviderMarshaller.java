package zw.co.hitrac.jaxcsd.api.marshal;

import java.text.ParseException;
import java.util.Date;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import zw.co.hitrac.jaxcsd.api.domain.Name;
import zw.co.hitrac.jaxcsd.api.domain.Person;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganization;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import zw.co.hitrac.jaxcsd.api.marshal.ext.ExtensionListMarshaller;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderMarshaller extends Marshaller<Provider> {

    private static final ProviderMarshaller INSTANCE = new ProviderMarshaller();

    private ProviderMarshaller() {
    }

    @Override
    public String marshal(Provider provider) {
        StringBuilder sb = new StringBuilder();
        sb.append("<provider oid=\"").append(provider.getOid()).append("\">");
        sb.append(OtherIDListMarshaller.get().marshal(provider.getOtherIDs()));
        sb.append(CodedTypeListMarshaller.get().marshal(provider.getCodedTypes(), "codedType"));
        sb.append(PersonMarshaller.get().marshal(provider.getDemographic()));
        sb.append(CodedTypeListMarshaller.get().marshal(provider.getLanguages(), "language"));
        sb.append(ProviderOrganizationsMarshaller.get().marshal(provider.getProviderOrganizations()));
        sb.append(ProviderFacilitiesMarshaller.get().marshal(provider.getProviderFacilities()));
        sb.append(CredentialListMarshaller.get().marshal(provider.getCredentials()));
        sb.append(CodedTypeListMarshaller.get().marshal(provider.getSpecialties(), "specialty"));
        sb.append(ExtensionListMarshaller.get().marshal(provider.getExtensions()));
        sb.append(RecordMarshaller.get().marshal(provider.getRecord()));
        sb.append("</provider>");
        return sb.toString();
    }

    public static ProviderMarshaller get() {
        return INSTANCE;
    }

    public static void main(String[] args) throws ParseException {
        Provider provider = new Provider();
        provider.setOid("1.3.6.1.4.1.21367.200.99.1111");
        provider.addCodedType("105-007", "1.3.6.1.4.1.21367.100.1", "Physician/Medical Oncology");
        Person demographic = new Person();
        demographic.addName(new Name("Dr.", "Banerjee", "Dev").addCommonName("Banargee, Dev"));
        demographic.addContactPoint(new ContactPoint(new CodedType("BP", "urn:ihe:iti:csd:2013:contactPoint", "555-777-1111")));
        demographic.addContactPoint(new ContactPoint(new CodedType("FAX", "urn:ihe:iti:csd:2013:contactPoint", "555-888-1111")));
        demographic.addAddress(new Address("Mailing")
                .addAddressLine("streetAddress", "8909 Sunset Way")
                .addAddressLine("city", "Santa Fe")
                .addAddressLine("stateProvince", "NM")
                .addAddressLine("country", "USA")
                .addAddressLine("postalCode", "87505"));
        demographic.setGender("M");
        provider.setDemographic(demographic);

        provider.addLanguage("en", "BCP 47", "English")
                .addLanguage("bn", "BCP 47", "Bengali");

        provider.addProviderOrganization(new ProviderOrganization("1.3.6.1.4.1.21367.200.99.1"))
                .addProviderOrganization(new ProviderOrganization("1.3.6.1.4.1.21367.200.99.3"));

        provider.addCredential(new Credential(new CodedType("109-003", "1.3.6.1.4.1.21367.100.1"), "108-001", "Connectathon_Manager", JaxCsdUtil.toDateFromIsoShortString("2013-12-01"), null));

        provider.addSpecialty("109-003", "1.3.6.1.4.1.21367.100.1", "");

        provider.setRecord(new Record(new Date(), new Date(), "Active"));
        System.out.println(provider.marshal());
    }
}
