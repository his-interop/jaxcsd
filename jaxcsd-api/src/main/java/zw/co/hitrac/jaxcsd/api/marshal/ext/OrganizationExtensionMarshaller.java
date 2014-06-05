package zw.co.hitrac.jaxcsd.api.marshal.ext;

import java.util.Map;
import java.util.UUID;
import zw.co.hitrac.jaxcsd.api.domain.ext.OrganizationExtension;
import zw.co.hitrac.jaxcsd.api.marshal.ExtensionMarshaller;

import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import zw.co.hitrac.jaxcsd.api.util.UUIDBasedOID;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationExtensionMarshaller extends ExtensionMarshaller<OrganizationExtension> {

    private static final OrganizationExtensionMarshaller INSTANCE=new OrganizationExtensionMarshaller();
        
    private OrganizationExtensionMarshaller() {
    }
    
    @Override
    protected Map<String, String> getAnyAttributes(OrganizationExtension organizationExtension) {
        return null;
    }

    @Override
    protected String getAnyXmlContent(OrganizationExtension organizationExtension) {
        StringBuilder sb = new StringBuilder();
        if (organizationExtension.getParentName() != null) {
            sb.append("<organizationExtension>");
            sb.append(getInlineXmlElement("parentName", organizationExtension.getParentName()));
            sb.append("</organizationExtension>");
        }
        return sb.toString();
    }

    public static OrganizationExtensionMarshaller get() {
        return INSTANCE;
    }
    
    
    
    public static void main(String[] args){
        ExtensionMarshaller<OrganizationExtension> extensionMarshaller=new OrganizationExtensionMarshaller();
        OrganizationExtension organizationExtension=new OrganizationExtension();
        organizationExtension.setType("province");
        organizationExtension.setOid(UUIDBasedOID.createOIDFromUUIDCanonicalHexString(UUID.randomUUID().toString()));
        organizationExtension.setParentName("Mashonaland East");
        System.out.println(extensionMarshaller.marshal(organizationExtension));
    }
}
