package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class RecordMarshaler extends Marshaler<Record> {

    private static final RecordMarshaler INSTANCE = new RecordMarshaler();

    private RecordMarshaler() {
    }

    @Override
    public String marshal(Record record, String elementName) {
        Map<String, String> attributes = new LinkedHashMap<String, String>();
        if (record.getCreated() != null) {
            attributes.put("created", JaxCsdUtil.toIsoDateFormat(record.getCreated()));
        }

        if (record.getUpdated() != null) {
            attributes.put("updated", JaxCsdUtil.toIsoDateFormat(record.getUpdated()));
        }

        if (record.getStatus() != null) {
            attributes.put("status", record.getStatus());
        }

        if (record.getSourceDirectory() != null) {
            attributes.put("sourceDirectory", record.getSourceDirectory());

        } else {
            attributes.put("sourceDirectory", "http://www.ihe.net");
        }

        return getInlineXmlElement(elementName, attributes);
    }

    @Override
    public String marshal(Record record) {
        return marshal(record, RECORD);
    }

    public static RecordMarshaler get() {
        return INSTANCE;
    }
}
