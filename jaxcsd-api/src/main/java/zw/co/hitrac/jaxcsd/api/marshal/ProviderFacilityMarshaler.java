package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.ProviderFacility;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderFacilityMarshaler extends Marshaler<ProviderFacility> {

    private static final ProviderFacilityMarshaler INSTANCE = new ProviderFacilityMarshaler();

    @Override
    public String marshal(ProviderFacility providerFacility) {
        return marshal(providerFacility, FACILITY);
    }

    @Override
    public String marshal(ProviderFacility providerFacility, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(" entityID=\"").append(providerFacility.getEntityID()).append("\">");
        //TODO: to add ProviderFacilityServiceListMarshaller here!
        //TODO: to add OperatingHoursListMarshaller here!
        sb.append(ExtensionListMarshaller.get().marshal(providerFacility.getExtensions()));
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    public static ProviderFacilityMarshaler get() {
        return INSTANCE;
    }
}
