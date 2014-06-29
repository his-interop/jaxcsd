package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Extension;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ExtensionListMarshaller extends Marshaler<List<Extension>> {

    private static final ExtensionListMarshaller INSTANCE = new ExtensionListMarshaller();

    public ExtensionListMarshaller() {
    }

    @Override
    public String marshal(List<Extension> extensions, String elementName) {
        StringBuilder sb = new StringBuilder();
        for (Extension extension : extensions) {
            sb.append(extension.marshal(elementName));
        }
        return sb.toString();
    }

    @Override
    public String marshal(List<Extension> extensions) {
        return marshal(extensions,EXTENSION);
    }

    public static ExtensionListMarshaller get() {
        return INSTANCE;
    }
}
