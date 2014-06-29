package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.msg.AttributesWrapper;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class CodedTypeMarshaler extends Marshaler<CodedType> {

    private static final CodedTypeMarshaler INSTANCE = new CodedTypeMarshaler();

    public CodedTypeMarshaler() {
    }

    @Override
    public String marshal(CodedType codedType, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append(getInlineXmlElement(elementName, codedType.getValue(), new AttributesWrapper("code", codedType.getCode()).add("codingSchema", codedType.getCodingSchema())));
        return sb.toString();
    }

    @Override
    public String marshal(CodedType codedType) {
        return this.marshal(codedType,CODED_TYPE);
    }

    public static CodedTypeMarshaler get() {
        return INSTANCE;
    }
}
