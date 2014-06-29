package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;
/**
 *
 * @author Charles Chigoriwa
 *
 */
public class OrganizationContactMarshaler extends Marshaler<AbstractOrganization.OrganizationContact> {

    private static final OrganizationContactMarshaler INSTANCE=new OrganizationContactMarshaler();
    
    
    @Override
    public String marshal(AbstractOrganization.OrganizationContact organizationContact) {
       return marshal(organizationContact, CONTACT);
    }

    @Override
    public String marshal(AbstractOrganization.OrganizationContact organizationContact, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (organizationContact.getPerson() != null || organizationContact.getProvider() != null) {
            sb.append("<").append(elementName).append(">");
            if (organizationContact.getPerson() != null) {
                sb.append(PersonMarshaler.get().marshal(organizationContact.getPerson(), "person"));
            } else if (organizationContact.getProvider() != null) {
                sb.append(UniqueIDMarshaler.get().marshal(organizationContact.getProvider(), "provider"));
            }
            sb.append("</").append(elementName).append(">");
        }
        return sb.toString();
    }

    public static OrganizationContactMarshaler get() {
        return INSTANCE;
    }
    
    
}
