package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.ProviderFacilities;
import zw.co.hitrac.jaxcsd.api.domain.ProviderFacility;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderFacilitiesMarshaler extends Marshaler<ProviderFacilities> {

    private static final ProviderFacilitiesMarshaler INSTANCE = new ProviderFacilitiesMarshaler();

    private ProviderFacilitiesMarshaler() {
    }

    @Override
    public String marshal(ProviderFacilities providerFacilities, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (providerFacilities != null && providerFacilities.getProviderFacilities() != null && !providerFacilities.getProviderFacilities().isEmpty()) {
            sb.append("<").append(elementName).append(">");
            for (ProviderFacility providerFacility : providerFacilities.getProviderFacilities()) {
                providerFacility.marshal();
            }
            sb.append("</").append(elementName).append(">");
        }
        return sb.toString();
    }

    @Override
    public String marshal(ProviderFacilities providerFacilities) {
       return marshal(providerFacilities, FACILITIES);
    }

    public static ProviderFacilitiesMarshaler get() {
        return INSTANCE;
    }
}
