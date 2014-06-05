package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Name;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil.toXml;

/**
 *
 * @author Charles Chigoriwa
 */
public class NameMarshaller extends Marshaller<Name> {

    private static final NameMarshaller INSTANCE = new NameMarshaller();

    private NameMarshaller() {
    }

    @Override
    public String marshal(Name name) {
        StringBuilder sb = new StringBuilder();
        sb.append("<name>");
        sb.append(toXml("commonName", name.getCommonNames()));
        if (name.getHonorific() != null) {
            sb.append(getInlineXmlElement("honorific", name.getHonorific()));
        }
        if (name.getForename() != null) {
            sb.append(getInlineXmlElement("forename", name.getForename()));
        }
        
        if (name.getSurname() != null) {
            sb.append(getInlineXmlElement("surname", name.getSurname()));
        }
        
        if (name.getSuffix() != null) {
            sb.append(getInlineXmlElement("suffix", name.getSuffix()));
        }
        sb.append(CodedTypeListMarshaller.get().marshal(name.getOtherNames(), "otherName"));
        sb.append("</name>");
        return sb.toString();
    }

    public static NameMarshaller get() {
        return INSTANCE;
    }
}
