package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class CredentialListMarshaler extends Marshaler<List<Credential>> {

    private static final CredentialListMarshaler INSTANCE = new CredentialListMarshaler();

    private CredentialListMarshaler() {
    }

    @Override
    public String marshal(List<Credential> credentials, String elementName) {
        StringBuilder sb = new StringBuilder();
        for (Credential credential : credentials) {
            sb.append(credential.marshal(elementName));
        }
        return sb.toString();
    }

    @Override
    public String marshal(List<Credential> credentials) {
        return marshal(credentials, CREDENTIAL);
    }

    public static CredentialListMarshaler get() {
        return INSTANCE;
    }
}
