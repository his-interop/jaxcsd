package zw.co.hitrac.jaxcsd.api.msg;

import zw.co.hitrac.jaxcsd.api.JaxcsdRuntimeException;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;
import zw.co.hitrac.jaxcsd.api.util.JaxcsdResponse;

/**
 *
 * @author Charles Chigoriwa
 */
public class AdHocXQueryRequestFactory {

    private static String getAdHocCareServicesRequest(String adHocQuery) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<c:careServicesRequest xmlns:c=\"urn:ihe:iti:csd:2013\">");
        sb.append("<c:expression content-type=\"text/xml\">");
        sb.append("<![CDATA[");
        sb.append(adHocQuery);
        sb.append("]]>");
        sb.append("</c:expression>");
        sb.append("</c:careServicesRequest>");
        return sb.toString();
    }

    public static String executeAdHocQuery(String adHocQuery, String httpAddress) {
        String xmlBody = getAdHocCareServicesRequest(adHocQuery);
        JaxcsdResponse jaxcsdResponse = JaxCsdUtil.executeXmlPost(xmlBody, httpAddress);
        if (jaxcsdResponse.getStatusCode() != 200) {
            throw new JaxcsdRuntimeException(jaxcsdResponse.toString());
        }
        return jaxcsdResponse.getBody();
    }

    public static void main(String[] args) {
        String httpAddress = "http://localhost:8984/CSD/csr/mohcc/careServicesRequest";
        StringBuilder sb = new StringBuilder();
        sb.append("declare namespace c = \"urn:ihe:iti:csd:2013\";");
        sb.append("declare variable $providers := /c:CSD/c:providerDirectory/c:provider;");
        sb.append("<providers>");
        sb.append("<names>");
        sb.append("{");
        sb.append("for $provider in $providers");
        sb.append(" return <name>{$provider/c:demographic/c:name/c:commonName/text()}</name>");
        sb.append("}");
        sb.append("</names>");
        sb.append("</providers>");
        String adHocQuery = sb.toString();
        String response = executeAdHocQuery(adHocQuery, httpAddress);
        System.out.println(response);
    }

    private AdHocXQueryRequestFactory() {
    }
}
