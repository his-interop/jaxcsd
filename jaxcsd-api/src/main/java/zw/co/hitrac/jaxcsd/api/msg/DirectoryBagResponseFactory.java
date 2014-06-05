package zw.co.hitrac.jaxcsd.api.msg;

import zw.co.hitrac.jaxcsd.api.domain.DirectoryBag;

/**
 *
 * @author Charles Chigoriwa
 */
public class DirectoryBagResponseFactory {
    
    
    public static String getCsdBagXml(DirectoryBag directoryBag){
        StringBuilder sb=new StringBuilder();
        sb.append("<CSD xmlns=\"urn:ihe:iti:csd:2013\">");
        sb.append(OrganizationResponseFactory.getOrganizationDirectoryXml(directoryBag.getOrganizations()));
        sb.append(ServiceResponseFactory.getServiceDirectoryXml(directoryBag.getServices()));
        sb.append(FacilityResponseFactory.getFacilityDirectoryXml(directoryBag.getFacilities()));
        sb.append(ProviderResponseFactory.getProviderDirectoryXml(directoryBag.getProviders()));
        sb.append("</CSD>");
        return sb.toString();
    }

    private DirectoryBagResponseFactory() {
    }
    
    
    
}
