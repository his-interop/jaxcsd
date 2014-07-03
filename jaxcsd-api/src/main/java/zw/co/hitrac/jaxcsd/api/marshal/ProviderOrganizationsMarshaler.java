package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganization;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganizations;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderOrganizationsMarshaler extends Marshaler<ProviderOrganizations> {

    private static final ProviderOrganizationsMarshaler INSTANCE = new ProviderOrganizationsMarshaler();

    private ProviderOrganizationsMarshaler() {
    }
    
    @Override
    public String marshal(ProviderOrganizations providerOrganizations, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (providerOrganizations != null && providerOrganizations.getProviderOrganizations() != null && !providerOrganizations.getProviderOrganizations().isEmpty()) {
            sb.append("<").append(elementName).append(">");
            for (ProviderOrganization providerOrganization : providerOrganizations.getProviderOrganizations()) {
                sb.append(providerOrganization.marshal());
            }
            sb.append("</").append(elementName).append(">");
        }
        return sb.toString();
    }

    @Override
    public String marshal(ProviderOrganizations providerOrganizations) {
       return marshal(providerOrganizations, ORGANIZATIONS);
    }

    public static ProviderOrganizationsMarshaler get() {
        return INSTANCE;
    }

    
}
