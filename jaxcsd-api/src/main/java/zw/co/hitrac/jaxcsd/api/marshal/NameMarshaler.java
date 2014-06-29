package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Name;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil.toXml;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class NameMarshaler extends Marshaler<Name> {

    private static final NameMarshaler INSTANCE = new NameMarshaler();

    private NameMarshaler() {
    }

    @Override
    public String marshal(Name name, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(">");
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
        sb.append(CodedTypeListMarshaler.get().marshal(name.getOtherNames(), "otherName"));
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    @Override
    public String marshal(Name name) {
        return marshal(name, NAME);
    }

    public static NameMarshaler get() {
        return INSTANCE;
    }
}
