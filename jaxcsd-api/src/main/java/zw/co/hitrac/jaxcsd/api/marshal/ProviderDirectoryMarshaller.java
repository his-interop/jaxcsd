package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.domain.ProviderDirectory;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderDirectoryMarshaller extends Marshaller<ProviderDirectory>{
    
    private static final ProviderDirectoryMarshaller INSTANCE=new ProviderDirectoryMarshaller();

    private ProviderDirectoryMarshaller() {
    }

    
    @Override
    public String marshal(ProviderDirectory providerDirectory) {
        StringBuilder sb=new StringBuilder();
        if(providerDirectory!=null  && providerDirectory.getProviders()!=null && !providerDirectory.getProviders().isEmpty()){
            sb.append("<providerDirectory>");
            for(Provider provider:providerDirectory.getProviders()){
                sb.append(provider.marshal());
            }
            sb.append("</providerDirectory>");
        }else{
            sb.append(MessageConstants.EMPTY_PROVIDER_DIRECTORY);
        }
        return sb.toString();
    }

    public static ProviderDirectoryMarshaller get() {
        return INSTANCE;
    }
    
    
    
}
