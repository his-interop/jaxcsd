package zw.co.hitrac.jaxcsd.api.msg.handler;

import org.xml.sax.Attributes;
import zw.co.hitrac.jaxcsd.api.msg.CsdRequest;
import zw.co.hitrac.jaxcsd.api.msg.MessageConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class SoapCsdHandler extends AbstractCsdHandler {

    protected boolean headerStarted = false;
    protected boolean headerEnded = false;
    protected static final String HEADER = "Header";
    protected static final String BODY = "Body";
    protected static final String ACTION = "Action";
    protected static final String MESSAGE_ID = "MessageID";
    protected static final String ADDRESS = "Address";
    protected static final String TO = "To";
    protected boolean bodyStarted = false;
    protected boolean bodyEnded = false;

    @Override
    public final void startElement(String namespaceURI, String sName, String qName, Attributes attrs) {
        ownStartElement(namespaceURI, sName, qName, attrs);
        childStartElement(namespaceURI, sName, qName, attrs);
    }

    @Override
    public final void endElement(String namespaceURI, String sName, String qName) {
        ownEndElement(namespaceURI, sName, qName);
        childEndElement(namespaceURI, sName, qName);
        stringBuilder = null;
    }

    private void ownStartElement(String namespaceURI, String sName, String qName, Attributes attrs) {
        if (getQualifiedName(namespaceURI, sName).equals(getQualifiedName(MessageConstants.SOAP_NS, HEADER))) {
            headerStarted = true;
        } else if (getQualifiedName(namespaceURI, sName).equals(getQualifiedName(MessageConstants.SOAP_NS, BODY))) {
            bodyStarted = true;
        }
    }

    private void ownEndElement(String namespaceURI, String sName, String qName) {
        if (getQualifiedName(namespaceURI, sName).equals(getQualifiedName(MessageConstants.SOAP_NS, HEADER))) {
            headerEnded = true;
        } else if (getQualifiedName(namespaceURI, sName).equals(getQualifiedName(MessageConstants.SOAP_NS, BODY))) {
            bodyEnded = true;
        }

        if (inHeaderMode()) {
            if (getQualifiedName(namespaceURI, sName).equals(getQualifiedName(MessageConstants.WSA_NS, ACTION))) {
                getCsdRequest().setAction(stringBuilder.toString());
            }

            if (getQualifiedName(namespaceURI, sName).equals(getQualifiedName(MessageConstants.WSA_NS, MESSAGE_ID))) {
                getCsdRequest().setMessageId(stringBuilder.toString());
            }

            if (getQualifiedName(namespaceURI, sName).equals(getQualifiedName(MessageConstants.WSA_NS, ADDRESS))) {
                getCsdRequest().setReplyToAddress(stringBuilder.toString());
            }

            if (getQualifiedName(namespaceURI, sName).equals(getQualifiedName(MessageConstants.WSA_NS, TO))) {
                getCsdRequest().setTo(stringBuilder.toString());
            }
        }
    }

    protected boolean inHeaderMode() {
        return headerStarted && !headerEnded;
    }

    protected boolean inBodyMode() {
        return bodyStarted && !bodyEnded;
    }

    protected abstract CsdRequest getCsdRequest();

    public abstract void childStartElement(String namespaceURI, String sName, String qName, Attributes attrs);

    protected abstract void childEndElement(String namespaceURI, String sName, String qName);
}
