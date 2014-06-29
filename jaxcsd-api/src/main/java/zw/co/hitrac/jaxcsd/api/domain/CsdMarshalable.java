package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;

/**
 *
 * @author Charles Chigoriwa
 */
public  interface CsdMarshalable extends Serializable{
    public String marshal();
    public String marshal(String elementName);
}
