package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.msg.AttributesWrapper;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class CodedTypeListMarshaller extends Marshaller<List<CodedType>>{
    
    private static final CodedTypeListMarshaller INSTANCE=new CodedTypeListMarshaller();

    private CodedTypeListMarshaller() {
    }

    @Override
    public String marshal(List<CodedType> codedTypes, String elementName) {
        StringBuilder sb=new StringBuilder();
          if (codedTypes != null && !codedTypes.isEmpty()) {
            for (CodedType codedType : codedTypes) {
                sb.append(getInlineXmlElement(elementName, codedType.getValue(), new AttributesWrapper("code", codedType.getCode()).add("codingSchema", codedType.getCodingSchema())));
            }
        }
        return sb.toString();
    }
    
    
    
    

    @Override
    public String marshal(List<CodedType> codedTypes) {
       return this.marshal(codedTypes, "codedType");
    }

    public static CodedTypeListMarshaller get() {
        return INSTANCE;
    }
    
    
    
}
