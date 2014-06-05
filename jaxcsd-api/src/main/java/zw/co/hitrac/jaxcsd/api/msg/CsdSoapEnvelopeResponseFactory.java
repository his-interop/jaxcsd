package zw.co.hitrac.jaxcsd.api.msg;

import zw.co.hitrac.jaxcsd.api.domain.DirectoryBag;

/**
 *
 * @author Charles Chigoriwa
 */
public class CsdSoapEnvelopeResponseFactory {

    public static String getSoapEnvelopXml(DirectoryBag directoryBag, String messageId, String relatesTo) {
        StringBuilder sb = new StringBuilder();
        sb.append("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" ");
        sb.append("xmlns:wsa=\"http://www.w3.org/2005/08/addressing\" ");
        sb.append("xmlns:csd=\"urn:ihe:iti:csd:2013\">");
        /* START SOAP HEADER*/
        sb.append("<soap:Header>");
        sb.append("<wsa:Action soap:mustUnderstand=\"1\">");
        sb.append("urn:ihe:iti:csd:2013:GetDirectoryModificationsResponse");
        sb.append("</wsa:Action>");
        sb.append("<wsa:MessageID>");
        sb.append("urn:uuid:").append(messageId);
        sb.append("</wsa:MessageID>");
        sb.append("<wsa:To soap:mustUnderstand=\"1\">");
        sb.append("http://www.w3.org/2005/08/addressing/anonymous");
        sb.append("</wsa:To>");
        sb.append("<wsa:RelatesTo>");
        sb.append(relatesTo);
        sb.append("</wsa:RelatesTo>");
        sb.append("</soap:Header>");
        /* END SOAP HEADER*/
        /*START SOAP BODY*/
        sb.append("<soap:Body>");
        sb.append(CsdSoapPayLoadResponseFactory.getCsdSoapPayloadXml(directoryBag));
        sb.append("</soap:Body>");
        /*END SOAP BODY*/
        sb.append("</soap:Envelope>");
        return sb.toString();
    }

    private CsdSoapEnvelopeResponseFactory() {
    }
}
