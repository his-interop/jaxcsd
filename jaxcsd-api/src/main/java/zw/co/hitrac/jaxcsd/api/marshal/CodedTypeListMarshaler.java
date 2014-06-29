package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class CodedTypeListMarshaler extends Marshaler<List<CodedType>> {

    private static final CodedTypeListMarshaler INSTANCE = new CodedTypeListMarshaler();

    private CodedTypeListMarshaler() {
    }

    @Override
    public String marshal(List<CodedType> codedTypes, String elementName) {
        StringBuilder sb = new StringBuilder();
        if (codedTypes != null && !codedTypes.isEmpty()) {
            for (CodedType codedType : codedTypes) {
                sb.append(codedType.marshal(elementName));
            }
        }
        return sb.toString();
    }

    @Override
    public String marshal(List<CodedType> codedTypes) {
        return this.marshal(codedTypes, CODED_TYPE);
    }

    public static CodedTypeListMarshaler get() {
        return INSTANCE;
    }
}
