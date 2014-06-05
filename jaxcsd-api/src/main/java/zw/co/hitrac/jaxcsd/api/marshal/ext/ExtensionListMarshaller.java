package zw.co.hitrac.jaxcsd.api.marshal.ext;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Extension;
import zw.co.hitrac.jaxcsd.api.domain.ext.FacilityOrganizationExtension;
import zw.co.hitrac.jaxcsd.api.domain.ext.OrganizationExtension;
import zw.co.hitrac.jaxcsd.api.domain.ext.ProviderFacilityExtension;
import zw.co.hitrac.jaxcsd.api.domain.ext.ProviderOrganizationExtension;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaller;

/**
 *
 * @author Charles Chigoriwa
 */
public class ExtensionListMarshaller extends Marshaller<List<Extension>>{
    
    private static final ExtensionListMarshaller INSTANCE=new ExtensionListMarshaller();

    private ExtensionListMarshaller() {
    }
    
    
    

    @Override
    public String marshal(List<Extension> extensions, String elementName) {
        StringBuilder sb=new StringBuilder();
        for(Extension extension:extensions){
            //TODO:: Introduce Runtime Binding here; should be more intelligent here
            if(extension instanceof OrganizationExtension){
                sb.append(OrganizationExtensionMarshaller.get().marshal((OrganizationExtension)extension, elementName));
            }else if(extension instanceof FacilityOrganizationExtension){
                sb.append(FacilityOrganizationExtensionMarshaller.get().marshal((FacilityOrganizationExtension)extension,elementName));
            }else if (extension instanceof ProviderOrganizationExtension){
                sb.append(ProviderOrganizationExtensionMarshaller.get().marshal((ProviderOrganizationExtension)extension, elementName));
            }else if (extension instanceof ProviderFacilityExtension){
                sb.append(ProviderFacilityExtensionMarshaller.get().marshal((ProviderFacilityExtension)extension, elementName));
            }
            
            //Add more static bindings while awaiting runtime binding (intelligent mechanism)
            
            
            
            
            
        }
        return sb.toString();
    }
    
    

    @Override
    public String marshal(List<Extension> extensions) {
       return marshal(extensions, "extension");
    }

    public static ExtensionListMarshaller get() {
        return INSTANCE;
    }

   
    
}
