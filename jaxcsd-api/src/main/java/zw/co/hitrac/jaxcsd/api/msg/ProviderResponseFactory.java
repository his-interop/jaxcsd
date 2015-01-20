package zw.co.hitrac.jaxcsd.api.msg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderResponseFactory {

    public static String getProviderDirectoryXml(List<Provider> providers) {
        StringBuilder sb = new StringBuilder();
        if (providers == null || providers.isEmpty()) {
            sb.append("<providerDirectory/>");
        } else {
            sb.append("<providerDirectory>");
            for (Provider provider : providers) {
                sb.append(getProviderXml(provider));
            }
            sb.append("</providerDirectory>");
        }
        return sb.toString();
    }

    private static String getProviderXml(Provider provider) {
        StringBuilder sb = new StringBuilder();
        sb.append("<provider entityID=\"").append(provider.getEntityID()).append("\">");
        sb.append(getCodedTypeXml(provider));
        sb.append(getDemographicXml(provider));
        sb.append(getRecordXml(provider));
        sb.append("</provider>");
        return sb.toString();
    }

    private static String getCodedTypeXml(Provider provider) {
        StringBuilder sb = new StringBuilder();
        List<CodedType> codedTypes = provider.getCodedTypes();
        if (codedTypes != null && !codedTypes.isEmpty()) {
            for (CodedType codedType : codedTypes) {
                sb.append(getInlineXmlElement("codedType", codedType.getValue(), new AttributesWrapper("code", codedType.getCode()).add("codingScheme", codedType.getCodingScheme())));
            }
        }
        return sb.toString();
    }

    private static String getDemographicXml(Provider provider) {
        StringBuilder sb = new StringBuilder();
        sb.append("<demographic>");
        sb.append(getDemographicNameXml(provider));
        sb.append("</demographic>");
        return sb.toString();
    }

    //TODO tomorrow 05/05/2014
    private static String getRecordXml(Provider provider) {
        String elementName = "record";
        Map<String, String> attributes = new LinkedHashMap<String, String>();
//            if (provider.getCreationDate() != null) {
//                attributes.put("created", JaxCsdUtil.toIsoDateFormat(provider.getCreationDate()));
//            }
//
//            if (provider.getLastUpdateDate() != null) {
//                attributes.put("updated", JaxCsdUtil.toIsoDateFormat(provider.getLastUpdateDate()));
//            }
//
//            if (provider.getProviderStatus() != null) {
//                attributes.put("status", provider.getProviderStatus().getValue());
//            }

        return getInlineXmlElement(elementName, attributes);
    }

    private static String getDemographicNameXml(Provider provider) {
        StringBuilder sb = new StringBuilder();
        sb.append("<name>");
       /* sb.append(toXml("commonName", provider.getNames()));
        sb.append(toXml("honorific", provider.getTitles()));
        sb.append(toXml("forename", provider.getFirstNames()));
        sb.append(toXml("otherNames", provider.getMiddleNames()));
        sb.append(toXml("surname", provider.getLastNames()));*/
        sb.append("</name>");
        return sb.toString();
    }

    private ProviderResponseFactory() {
    }

    public static void main(String[] args) {
        Provider provider = new Provider();
        provider.setEntityID("urn:oid:1.3.6.1.4.1.21367.200.99.1111");
        List<CodedType> codedTypes = new ArrayList<CodedType>();
        CodedType codedType = new CodedType();
        codedType.setCode("105-007");
        codedType.setCodingScheme("1.3.6.1.4.1.21367.100.1");
        codedType.setValue("Physician/Medical Oncology");
        codedTypes.add(codedType);
        provider.setCodedTypes(codedTypes);
        List<String> names = new ArrayList<String>();
        names.add("Banargee, Dev");
//        provider.setNames(names);
//        provider.setTitles(JaxCsdUtil.initItems("Dr."));
//        provider.setFirstNames(JaxCsdUtil.initItems("Dev"));
//        provider.setLastNames(JaxCsdUtil.initItems("Banerjee"));
//        provider.setCreationDate(new Date());
//        provider.setLastUpdateDate(new Date());
//        provider.setProviderStatus(Provider.ProviderStatus.ACTIVE);
        System.out.println(getProviderDirectoryXml(Arrays.asList(provider)));
    }
}
