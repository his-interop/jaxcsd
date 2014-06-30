package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Organization;
import zw.co.hitrac.jaxcsd.api.domain.OrganizationDirectory;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationDirectoryParser extends AbstractCsdParser<OrganizationDirectory> {

    private OrganizationParser organizationParser = new OrganizationParser();
    
    public static final CsdElement organizationElement=new CsdElement(ORGANIZATION);

    public void parse(OrganizationDirectory organizationDirectory,CsdElement organizationDirectoryElement,  XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if (organizationElement.elementEquals(r)) {
                    Organization organization = new Organization();
                    organization.setOid(r.getAttributeValue("", "oid"));
                    organizationDirectory.getOrganizations().add(organization);
                    organizationParser.parse(organization,organizationElement,r, csdParserExtensions);
                }
            } else if (r.isEndElement()) {
                if (organizationDirectoryElement.elementEquals(r)) {
                    break;
                }
            }
        }
    }

    public void setOrganizationParser(OrganizationParser organizationParser) {
        this.organizationParser = organizationParser;
    }
}
