package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Organization;
import zw.co.hitrac.jaxcsd.api.domain.OrganizationDirectory;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationDirectoryMarshaler extends Marshaler<OrganizationDirectory> {

    private static final OrganizationDirectoryMarshaler INSTANCE = new OrganizationDirectoryMarshaler();

    public OrganizationDirectoryMarshaler() {
    }

    @Override
    public String marshal(OrganizationDirectory organizationDirectory, String elementName) {
         StringBuilder sb = new StringBuilder();
        if (organizationDirectory != null && organizationDirectory.getOrganizations() != null && !organizationDirectory.getOrganizations().isEmpty()) {
            sb.append("<").append(elementName).append(">");
            for (Organization organization : organizationDirectory.getOrganizations()) {
                sb.append(organization.marshal());
            }
            sb.append("</").append(elementName).append(">");
        } else {
            sb.append(MessageConstants.EMPTY_ORGANIZATION_DIRECTORY);
        }
        return sb.toString();
    }

    @Override
    public String marshal(OrganizationDirectory organizationDirectory) {
      return marshal(organizationDirectory, ORGANIZATION_DIRECTORY);
    }

    public static OrganizationDirectoryMarshaler get() {
        return INSTANCE;
    }
}
