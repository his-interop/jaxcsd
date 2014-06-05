package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganization;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganizations;
import zw.co.hitrac.jaxcsd.api.marshal.ext.ExtensionListMarshaller;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderOrganizationsMarshaller extends Marshaller<ProviderOrganizations> {

    private static final ProviderOrganizationsMarshaller INSTANCE=new ProviderOrganizationsMarshaller();
    
    
    private ProviderOrganizationsMarshaller() {
    }
    
    

    @Override
    public String marshal(ProviderOrganizations providerOrganizations) {
        StringBuilder sb = new StringBuilder();
        if (providerOrganizations != null && providerOrganizations.getProviderOrganizations() != null && !providerOrganizations.getProviderOrganizations().isEmpty()) {
            sb.append("<organizations>");
            for (ProviderOrganization providerOrganization : providerOrganizations.getProviderOrganizations()) {
                sb.append("<organization oid=\"").append(providerOrganization.getOid()).append("\">");
                sb.append(ExtensionListMarshaller.get().marshal(providerOrganization.getExtensions()));
                //TODO:: To verify and AddressListMarshaller as well as ContactPointListMarshaller where agreed!
                sb.append("</organization>");
            }
            sb.append("</organizations>");
        }
        return sb.toString();
    }

    public static ProviderOrganizationsMarshaller get() {
        return INSTANCE;
    }
    
    
}
