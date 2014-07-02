package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.LinkedHashMap;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.msg.AttributesWrapper;
import zw.co.hitrac.jaxcsd.api.query.RequestParams;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class RequestParamsMarshaler extends Marshaler<RequestParams> {

    private static final RequestParamsMarshaler INSTANCE = new RequestParamsMarshaler();

    private RequestParamsMarshaler() {
    }

    @Override
    public String marshal(RequestParams requestParams) {
        return marshal(requestParams,REQUEST_PARAMS);
    }

    public static RequestParamsMarshaler get() {
        return INSTANCE;
    }

    @Override
    public String marshal(RequestParams requestParams, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(">");
        if (requestParams != null) {
            if (requestParams.getUniqueID() != null && requestParams.getUniqueID().getOid() != null) {
                sb.append(getInlineXmlElement("id", new AttributesWrapper("oid", requestParams.getUniqueID().getOid())));
            }

            if (requestParams.getCommonName() != null) {
                sb.append(getInlineXmlElement("commonName", requestParams.getCommonName()));
            }

            if (requestParams.getCodedType() != null) {
                Map<String, String> attributes = new LinkedHashMap<String, String>();
                attributes.put("code", requestParams.getCodedType().getCode());
                attributes.put("codingScheme", requestParams.getCodedType().getCodingScheme());
                sb.append(getInlineXmlElement("codedType", attributes));
            }

            if (requestParams.getOtherID() != null) {
                Map<String, String> attributes = new LinkedHashMap<String, String>();
                attributes.put("code", requestParams.getOtherID().getCode());
                attributes.put("assigningAuthorityName", requestParams.getOtherID().getAssigningAuthorityName());
                sb.append(getInlineXmlElement("otherID", attributes));
            }

            if (requestParams.getStart() != null) {
                sb.append(getInlineXmlElement("start", String.valueOf(requestParams.getStart())));
            }

            if (requestParams.getMax() != null) {
                sb.append(getInlineXmlElement("max", String.valueOf(requestParams.getMax())));
            }

            if (requestParams.getPushRequest() != null) {
                sb.append(requestParams.getPushRequest().marshal());
            }
        }
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }
}
