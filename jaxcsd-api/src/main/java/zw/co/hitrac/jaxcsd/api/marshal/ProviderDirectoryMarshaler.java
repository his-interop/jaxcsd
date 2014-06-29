package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.domain.ProviderDirectory;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderDirectoryMarshaler extends Marshaler<ProviderDirectory> {

    private static final ProviderDirectoryMarshaler INSTANCE = new ProviderDirectoryMarshaler();

    private ProviderDirectoryMarshaler() {
    }

    @Override
    public String marshal(ProviderDirectory providerDirectory, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (providerDirectory != null && providerDirectory.getProviders() != null && !providerDirectory.getProviders().isEmpty()) {
            sb.append("<").append(elementName).append(">");
            for (Provider provider : providerDirectory.getProviders()) {
                sb.append(provider.marshal());
            }
            sb.append("</").append(elementName).append(">");
        } else {
            sb.append(MessageConstants.EMPTY_PROVIDER_DIRECTORY);
        }
        return sb.toString();
    }

    @Override
    public String marshal(ProviderDirectory providerDirectory) {
        return marshal(providerDirectory, PROVIDER_DIRECTORY);
    }

    public static ProviderDirectoryMarshaler get() {
        return INSTANCE;
    }
}
