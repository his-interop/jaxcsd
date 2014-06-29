package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.AbstractOrganization.OrganizationContact;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationContactListMarshaler extends Marshaler<List<OrganizationContact>> {

    private static final OrganizationContactListMarshaler INSTANCE = new OrganizationContactListMarshaler();

    private OrganizationContactListMarshaler() {
    }

    @Override
    public String marshal(List<OrganizationContact> organizationContacts) {
       return marshal(organizationContacts, CONTACT);
    }

    public static OrganizationContactListMarshaler get() {
        return INSTANCE;
    }

    @Override
    public String marshal(List<OrganizationContact> organizationContacts, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (organizationContacts != null && !organizationContacts.isEmpty()) {
            for (OrganizationContact organizationContact : organizationContacts) {
               sb.append(organizationContact.marshal(elementName));
            }
        }
        return sb.toString();
    }
}
