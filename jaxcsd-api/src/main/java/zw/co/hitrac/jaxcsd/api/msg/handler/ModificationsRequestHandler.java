package zw.co.hitrac.jaxcsd.api.msg.handler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import zw.co.hitrac.jaxcsd.api.msg.CsdRequest;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;
import zw.co.hitrac.jaxcsd.api.msg.ModificationsRequest;

/**
 *
 * @author Charles Chigoriwa
 */
public class ModificationsRequestHandler extends SoapCsdHandler {

    private ModificationsRequest modificationsRequest;
    private final static String GET_MODIFICATIONS_REQUEST = "getModificationsRequest";
    private final static String LAST_MODIFIED = "lastModified";
    private boolean getModificationsRequestStarted = false;
    private boolean getModificationsRequestEnded = false;

    @Override
    public void childStartElement(String namespaceURI, String sName, String qName, Attributes attrs) {
        if (inBodyMode()) {
            if (getQualifiedName(namespaceURI, sName).equals(getQualifiedName(MessageConstants.CSD_NS, GET_MODIFICATIONS_REQUEST))) {
                getModificationsRequestStarted = true;
            }
        }
    }

    @Override
    public void childEndElement(String namespaceURI, String sName, String qName) {
        if (inBodyMode()) {
            if (getQualifiedName(namespaceURI, sName).equals(getQualifiedName(MessageConstants.CSD_NS, GET_MODIFICATIONS_REQUEST))) {
                getModificationsRequestEnded = true;
            }
        }

        if (inGetModificationsRequestMode()) {
            if (getQualifiedName(namespaceURI, sName).equals(getQualifiedName(MessageConstants.CSD_NS, LAST_MODIFIED))) {
                getModificationsRequest().setLastModified(stringBuilder.toString());
            }
        }
    }

    private boolean inGetModificationsRequestMode() {
        return getModificationsRequestStarted && !getModificationsRequestEnded;
    }

    @Override
    protected CsdRequest getCsdRequest() {
        if (modificationsRequest == null) {
            modificationsRequest = new ModificationsRequest();
        }
        return modificationsRequest;
    }

    public ModificationsRequest getModificationsRequest() {
        return (ModificationsRequest) getCsdRequest();
    }

    public static ModificationsRequest parse(String soapMessage) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        SAXParser saxParser = factory.newSAXParser();
        saxParser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        ModificationsRequestHandler handler = new ModificationsRequestHandler();
        saxParser.parse(new ByteArrayInputStream(soapMessage.getBytes()), handler);
        return handler.getModificationsRequest();
    }

    public static void main(String[] args) {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        s += "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" "
                + "xmlns:wsa=\"http://www.w3.org/2005/08/addressing\" xmlns:csd=\"urn:ihe:iti:csd:2013\">";
        s += "<soap:Header>";
        s += "<wsa:Action soap:mustUnderstand=\"1\">urn:ihe:iti:csd:2013:GetDirectoryModificationsRequest</wsa:Action>";
        s += "<wsa:MessageID>urn:uuid:def119ad-dc13-49c1-a3c7-e3742531f9b3</wsa:MessageID>";
        s += "<wsa:ReplyTo soap:mustUnderstand=\"1\">";
        s += "<wsa:Address>http://www.w3.org/2005/08/addressing/anonymous</wsa:Address>";
        s += "</wsa:ReplyTo>";
        s += "<wsa:To soap:mustUnderstand=\"1\">http://host/csDirectory</wsa:To>";
        s += "</soap:Header>";
        s += "<soap:Body>";
        s += "<csd:getModificationsRequest>";
        s += "<csd:lastModified>2002-05-30T09:30:10.5</csd:lastModified>";
        s += "</csd:getModificationsRequest>";
        s += "</soap:Body>";
        s += "</soap:Envelope>";
        try {
            System.out.println(parse(s));
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }







    }
}
