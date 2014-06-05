package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.ProviderFacilities;
import zw.co.hitrac.jaxcsd.api.domain.ProviderFacility;
import zw.co.hitrac.jaxcsd.api.marshal.ext.ExtensionListMarshaller;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderFacilitiesMarshaller extends Marshaller<ProviderFacilities>{
    
    private static final ProviderFacilitiesMarshaller INSTANCE=new ProviderFacilitiesMarshaller();

    private ProviderFacilitiesMarshaller() {
    }
    
    

    @Override
    public String marshal(ProviderFacilities providerFacilities) {
      StringBuilder sb=new StringBuilder();
      if(providerFacilities!=null && providerFacilities.getProviderFacilities()!=null && !providerFacilities.getProviderFacilities().isEmpty()){
          sb.append("<facilities>");
          for(ProviderFacility providerFacility:providerFacilities.getProviderFacilities()){
              sb.append("<facility oid=\"").append(providerFacility.getOid()).append("\">");
              //TODO: to add ProviderFacilityServiceListMarshaller here!
              //TODO: to add OperatingHoursListMarshaller here!
              sb.append(ExtensionListMarshaller.get().marshal(providerFacility.getExtensions()));
              sb.append("</facility>");
          }
          sb.append("</facilities>");
      }
      return sb.toString();
    }

    public static ProviderFacilitiesMarshaller get() {
        return INSTANCE;
    }
    
}
