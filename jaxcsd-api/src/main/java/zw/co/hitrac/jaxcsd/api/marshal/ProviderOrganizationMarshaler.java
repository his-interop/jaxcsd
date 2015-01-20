package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganization;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderOrganizationMarshaler extends Marshaler<ProviderOrganization> {
    
    private static final ProviderOrganizationMarshaler INSTANCE=new ProviderOrganizationMarshaler();

    @Override
    public String marshal(ProviderOrganization providerOrganization) {
        return marshal(providerOrganization, ORGANIZATION);
    }

    @Override
    public String marshal(ProviderOrganization providerOrganization, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(" entityID=\"").append(providerOrganization.getEntityID()).append("\">");
        sb.append(ExtensionListMarshaller.get().marshal(providerOrganization.getExtensions()));
        //TODO:: To verify and AddressListMarshaller as well as ContactPointListMarshaller where agreed!
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    public static ProviderOrganizationMarshaler get() {
        return INSTANCE;
    }
    
    
}
