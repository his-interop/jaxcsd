package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class RecordMarshaller extends Marshaller<Record>{
    
    private static final RecordMarshaller INSTANCE=new RecordMarshaller();

    private RecordMarshaller() {
    }
    
    

    @Override
    public String marshal(Record record) {
        String elementName = "record";
        Map<String, String> attributes = new LinkedHashMap<String, String>();
            if (record.getCreated() != null) {
                attributes.put("created", JaxCsdUtil.toIsoDateFormat(record.getCreated()));
            }

            if (record.getUpdated()!= null) {
                attributes.put("updated", JaxCsdUtil.toIsoDateFormat(record.getUpdated()));
            }

            if (record.getStatus() != null) {
                attributes.put("status", record.getStatus());
            }
            
            attributes.put("sourceDirectory","http://www.ihe.net");

        return getInlineXmlElement(elementName, attributes);
    }

    public static RecordMarshaller get() {
        return INSTANCE;
    }
    
    
    
}
