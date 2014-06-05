package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization.OrganizationContact;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationContactListMarshaller extends Marshaller<List<OrganizationContact>> {

    
    private static final OrganizationContactListMarshaller INSTANCE=new OrganizationContactListMarshaller();
    
    private OrganizationContactListMarshaller() {
    }

    
    
    
    @Override
    public String marshal(List<OrganizationContact> organizationContacts) {
        StringBuilder sb = new StringBuilder();
        if (organizationContacts != null && !organizationContacts.isEmpty()) {
            for (OrganizationContact organizationContact : organizationContacts) {
                if (organizationContact.getPerson() != null || organizationContact.getProvider() != null) {
                    sb.append("<contact>");
                    if (organizationContact.getPerson() != null) {
                        sb.append(PersonMarshaller.get().marshal(organizationContact.getPerson(), "person"));
                    } else if (organizationContact.getProvider() != null) {
                        sb.append(UniqueIDMarshaller.get().marshal(organizationContact.getProvider(), "provider"));
                    }
                    sb.append("</contact>");
                }
            }
        }
        return sb.toString();
    }

    public static OrganizationContactListMarshaller get() {
        return INSTANCE;
    }
    
    
}
