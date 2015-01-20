package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.ProviderFacilities;
import zw.co.hitrac.jaxcsd.api.domain.ProviderFacility;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderFacilitiesParser extends AbstractCsdParser<ProviderFacilities> {
    
    private ProviderFacilityParser providerFacilityParser=new ProviderFacilityParser();

    @Override
    public void parse(ProviderFacilities providerFacilities, CsdElement providerFacilitiesElement, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if(r.isStartElement()){
                if (FACILITY_ELEMENT.elementEquals(r)) {
                    ProviderFacility providerFacility=new ProviderFacility();
                    providerFacility.setEntityID(r.getAttributeValue("", "entityID"));
                    providerFacilities.addProviderFacility(providerFacility);
                    providerFacilityParser.parse(providerFacility,FACILITY_ELEMENT, r, csdParserExtensions);
                }
            }else if (r.isEndElement()) {
                if (providerFacilitiesElement.elementEquals(r)) {
                    break;
                }
            }
         }
    }

    public void setProviderFacilityParser(ProviderFacilityParser providerFacilityParser) {
        this.providerFacilityParser = providerFacilityParser;
    }
    
    
    
    public static final CsdElement FACILITY_ELEMENT=new CsdElement(CsdElementConstants.FACILITY);
}
