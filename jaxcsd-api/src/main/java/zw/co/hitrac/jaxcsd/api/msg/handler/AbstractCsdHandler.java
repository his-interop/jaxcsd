package zw.co.hitrac.jaxcsd.api.msg.handler;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class AbstractCsdHandler extends DefaultHandler {

    protected StringBuilder stringBuilder;
    public static final String EMPTY_NAMESPACE = "";

    @Override
    public void startDocument() throws SAXException {
        //do nothing
    }

    @Override
    public void characters(char[] ch, int offset, int len) {
        String s = new String(ch, offset, len);
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder(s);
        } else {
            stringBuilder.append(s);
        }
    }

    @Override
    public void endDocument() {
        //do nothing method
    }

    // treat validation errors as fatal
    @Override
    public void error(SAXParseException e)
            throws SAXParseException {
        throw e;
    }

    // dump warnings too
    @Override
    public void warning(SAXParseException err) throws SAXParseException {
        System.out.println("** Warning"
                + ", line " + err.getLineNumber()
                + ", uri " + err.getSystemId());
        System.out.println("   " + err.getMessage());
    }

    protected String getQualifiedName(String namespaceURI, String sName) {
        namespaceURI = namespaceURI == null ? EMPTY_NAMESPACE : namespaceURI;
        return namespaceURI.trim() + ":" + sName;
    }
}
