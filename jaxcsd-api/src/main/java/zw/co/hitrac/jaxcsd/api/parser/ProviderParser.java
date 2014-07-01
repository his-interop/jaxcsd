package zw.co.hitrac.jaxcsd.api.parser;

import zw.co.hitrac.jaxcsd.api.parser.util.HandlerUtils;
import zw.co.hitrac.jaxcsd.api.parser.ext.DefaultProviderExtensionParser;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import zw.co.hitrac.jaxcsd.api.domain.OtherID;
import zw.co.hitrac.jaxcsd.api.domain.Person;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.domain.ProviderFacilities;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganizations;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderParser extends AbstractCsdParser<Provider> {

    private DefaultProviderExtensionParser defaultProviderExtensionParser = new DefaultProviderExtensionParser();
    private PersonParser personParser = new PersonParser();
    private ProviderOrganizationsParser providerOrganizationsParser = new ProviderOrganizationsParser();
    private ProviderFacilitiesParser providerFacilitiesParser = new ProviderFacilitiesParser();

    public void parse(Provider provider, CsdElement providerElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {

        while (r.hasNext()) {
            r.next();

            if (r.isStartElement()) {
                if ("otherID".equals(r.getLocalName())) {
                    OtherID otherID = HandlerUtils.getOtherID(r);
                    provider.getOtherIDs().add(otherID);
                } else if ("codedType".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    provider.getCodedTypes().add(codedType);
                } else if (DEMOGRAPHIC_ELEMENT.elementEquals(r)) {
                    Person demographic = new Person();
                    provider.setDemographic(demographic);
                    personParser.parse(demographic, DEMOGRAPHIC_ELEMENT, r, csdParserExtensions);
                } else if ("language".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    provider.getLanguages().add(codedType);
                } else if (ORGANIZATIONS_ELEMENT.elementEquals(r)) {
                    ProviderOrganizations providerOrganizations = new ProviderOrganizations();
                    provider.setProviderOrganizations(providerOrganizations);
                    providerOrganizationsParser.parse(providerOrganizations, ORGANIZATIONS_ELEMENT, r, csdParserExtensions);
                } else if (FACILITIES_ELEMENT.elementEquals(r)) {
                    ProviderFacilities providerFacilities = new ProviderFacilities();
                    provider.setProviderFacilities(providerFacilities);
                    providerFacilitiesParser.parse(providerFacilities, FACILITIES_ELEMENT, r, csdParserExtensions);
                } else if ("credential".equals(r.getLocalName())) {
                    Credential credential = HandlerUtils.getCredential(r);
                    provider.addCredential(credential);
                } else if ("specialty".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    provider.getSpecialties().add(codedType);
                } else if (extensionElement.elementEquals(r)) {
                    if (csdParserExtensions != null && csdParserExtensions.getProviderExtensionParser() != null) {
                        csdParserExtensions.getProviderExtensionParser().parse(provider, extensionElement, r, csdParserExtensions);
                    } else {
                        this.defaultProviderExtensionParser.parse(provider, extensionElement, r, csdParserExtensions);
                    }
                } else if (recordElement.elementEquals(r)) {
                    Record record = HandlerUtils.getRecord(r);
                    provider.setRecord(record);
                }


            } else if (r.isEndElement()) {
                if (providerElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }

    public DefaultProviderExtensionParser getDefaultProviderExtensionParser() {
        return defaultProviderExtensionParser;
    }

    public void setDefaultProviderExtensionParser(DefaultProviderExtensionParser defaultProviderExtensionParser) {
        this.defaultProviderExtensionParser = defaultProviderExtensionParser;
    }

    public void setPersonParser(PersonParser personParser) {
        this.personParser = personParser;
    }

    public void setProviderOrganizationsParser(ProviderOrganizationsParser providerOrganizationsParser) {
        this.providerOrganizationsParser = providerOrganizationsParser;
    }

    public void setProviderFacilitiesParser(ProviderFacilitiesParser providerFacilitiesParser) {
        this.providerFacilitiesParser = providerFacilitiesParser;
    }

    
    
    public static final CsdElement ORGANIZATIONS_ELEMENT = new CsdElement(CsdElementConstants.ORGANIZATIONS);
    public static final CsdElement FACILITIES_ELEMENT = new CsdElement(CsdElementConstants.FACILITIES);
    public static final CsdElement DEMOGRAPHIC_ELEMENT = new CsdElement(CsdElementConstants.DEMOGRAPHIC);
}
