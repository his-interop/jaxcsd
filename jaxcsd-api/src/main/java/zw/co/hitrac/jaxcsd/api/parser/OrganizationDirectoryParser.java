package zw.co.hitrac.jaxcsd.api.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.Organization;
import zw.co.hitrac.jaxcsd.api.domain.OrganizationDirectory;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;

/**
 *
 * @author Charles Chigoriwa
 */
public class OrganizationDirectoryParser extends AbstractCsdParser<OrganizationDirectory> {

    private OrganizationParser organizationParser = new OrganizationParser();

    public void parse(OrganizationDirectory organizationDirectory, XMLStreamReader r, CsdParserExtensions csdParserExtensions) throws XMLStreamException {
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                if ("organization".equals(r.getLocalName())) {
                    Organization organization = new Organization();
                    organization.setOid(r.getAttributeValue("", "oid"));
                    organizationDirectory.getOrganizations().add(organization);
                    organizationParser.parse(organization, r, csdParserExtensions);
                }
            } else if (r.isEndElement()) {
                if ("organizationDirectory".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }

    public void setOrganizationParser(OrganizationParser organizationParser) {
        this.organizationParser = organizationParser;
    }
}
