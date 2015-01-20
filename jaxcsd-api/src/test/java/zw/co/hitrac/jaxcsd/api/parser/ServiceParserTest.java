package zw.co.hitrac.jaxcsd.api.parser;

import java.io.ByteArrayInputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import junit.framework.TestCase;
import zw.co.hitrac.jaxcsd.api.domain.Service;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class ServiceParserTest extends TestCase {

    public ServiceParserTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of parse method, of class ServiceParser.
     */
    public void testParse() throws Exception {
        System.out.println("parse");

        String xml = "<myService entityID=\"urn:oid:1.3.6.1.4.1.21367.200.99.111.101.101\">\n"
                + "			<codedType code=\"101-001\" codingScheme=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "			<record created=\"2013-12-01T14:00:00+00:00\" updated=\"2013-12-01T14:00:00+00:00\" status=\"Active\" sourceDirectory=\"http://www.ihe.net\"/>\n"
                + "</myService>";

        XMLInputFactory f = XMLInputFactory.newInstance();
        XMLStreamReader r = f.createXMLStreamReader(new ByteArrayInputStream(xml.getBytes()));
        r.next();
        Service service = new Service();
        service.setEntityID(r.getAttributeValue("", "entityID"));
        CsdElement servicelement = new CsdElement("myService");
        CsdParserExtensions csdParserExtensions = null;
        ServiceParser serviceParser = new ServiceParser();
        serviceParser.parse(service, servicelement, r, csdParserExtensions);
        assertTrue(!service.getCodedTypes().isEmpty());
        assertTrue("Active".equals(service.getRecord().getStatus()));
    }
}
