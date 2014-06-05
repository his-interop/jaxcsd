package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganization;
import zw.co.hitrac.jaxcsd.api.domain.FacilityOrganizations;

/**
 *
 * @author Charles Chigoriwa
 */
public class FacilityOrganizationsHandler {
    
     public static void handle(FacilityOrganizations organizations, XMLStreamReader r) throws XMLStreamException {
         while(r.hasNext()){
             r.next();
             if(r.isStartElement()){
                 if("organization".equals(r.getLocalName())){
                     FacilityOrganization organization=new FacilityOrganization();
                     organization.setOid(r.getAttributeValue("", "oid"));
                     organizations.getFacilityOrganizations().add(organization);
                     FacilityOrganizationHandler.handle(organization,r);
                 }
                 
             }else if(r.isEndElement()){
                 if("organizations".equals(r.getLocalName())){
                     break;
                 }
             }
         }
     }
    
}
