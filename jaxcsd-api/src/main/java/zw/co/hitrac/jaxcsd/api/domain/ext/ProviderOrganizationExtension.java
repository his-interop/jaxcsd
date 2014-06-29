package zw.co.hitrac.jaxcsd.api.domain.ext;

import zw.co.hitrac.jaxcsd.api.domain.Extension;

/**
 *
 * @author Charles Chigoriwa
 */
public class ProviderOrganizationExtension extends Extension {

    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String marshal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String marshal(String elementName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
