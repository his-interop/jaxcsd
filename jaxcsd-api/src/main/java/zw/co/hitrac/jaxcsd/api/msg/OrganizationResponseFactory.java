package zw.co.hitrac.jaxcsd.api.msg;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Organization;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationResponseFactory {

    public static String getOrganizationDirectoryXml(List<Organization> organizations) {
        StringBuilder sb = new StringBuilder();
        if (true || organizations == null || organizations.isEmpty()) {
            sb.append("<organizationDirectory/>");
        }
        return sb.toString();
    }

    private OrganizationResponseFactory() {
    }
}
