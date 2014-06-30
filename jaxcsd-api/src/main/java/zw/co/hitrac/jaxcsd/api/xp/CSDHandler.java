package zw.co.hitrac.jaxcsd.api.xp;

import java.io.ByteArrayInputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CSD;
import zw.co.hitrac.jaxcsd.api.domain.FacilityDirectory;
import zw.co.hitrac.jaxcsd.api.domain.OrganizationDirectory;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.domain.ProviderDirectory;
import zw.co.hitrac.jaxcsd.api.domain.ServiceDirectory;

/**
 *
 * @author Charles Chigoriwa
 */
public class CSDHandler {

    public static CSD getCSD(String xmlBody) throws XMLStreamException {
        CSD csd = null;
        XMLInputFactory f = XMLInputFactory.newInstance();
        XMLStreamReader r = f.createXMLStreamReader(new ByteArrayInputStream(xmlBody.getBytes()));
        while (r.hasNext()) {
            r.next();
            if (r.isStartElement()) {
                String localName = r.getLocalName();
                if ("CSD".equals(localName)) {
                    csd = new CSD();
                } else if ("organizationDirectory".equals(localName)) {
                    if (csd != null) {
                        csd.setOrganizationDirectory(new OrganizationDirectory());
                        OrganizationDirectoryHandler.handle(csd.getOrganizationDirectory(), r);
                    }
                } else if ("serviceDirectory".equals(localName)) {
                    if (csd != null) {
                        csd.setServiceDirectory(new ServiceDirectory());
                    }
                } else if ("facilityDirectory".equals(localName)) {
                    if (csd != null) {
                        csd.setFacilityDirectory(new FacilityDirectory());
                        FacilityDirectoryHandler.handle(csd.getFacilityDirectory(), r);
                    }
                } else if ("providerDirectory".equals(localName)) {
                    if (csd != null) {
                        csd.setProviderDirectory(new ProviderDirectory());
                        ProviderDirectoryHandler.handle(csd.getProviderDirectory(), r);
                    }
                }
            }

        }
        return csd;
    }
  
}
