package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Organization;
import zw.co.hitrac.jaxcsd.api.domain.OrganizationDirectory;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationDirectoryMarshaller extends Marshaller<OrganizationDirectory>{
    
    private static final OrganizationDirectoryMarshaller INSTANCE=new OrganizationDirectoryMarshaller();

    private OrganizationDirectoryMarshaller() {
    }
    
    

    @Override
    public String marshal(OrganizationDirectory organizationDirectory) {
        StringBuilder sb=new StringBuilder();
        if(organizationDirectory!=null && organizationDirectory.getOrganizations()!=null && !organizationDirectory.getOrganizations().isEmpty()){
            sb.append("<organizationDirectory>");
            for(Organization organization:organizationDirectory.getOrganizations()){
                sb.append(organization.marshal());
            }
            sb.append("</organizationDirectory>");
        }else{
            sb.append(MessageConstants.EMPTY_ORGANIZATION_DIRECTORY);
        }
        return sb.toString();
    }

    public static OrganizationDirectoryMarshaller get() {
        return INSTANCE;
    }
    
    
}
