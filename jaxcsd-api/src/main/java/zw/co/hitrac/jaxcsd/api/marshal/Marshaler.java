package zw.co.hitrac.jaxcsd.api.marshal;

import java.io.Serializable;

/**
 *
 * @author charles
 */
public abstract class Marshaler<T> implements Serializable {

    public abstract String marshal(T t);

    public abstract String marshal(T t, String elementName);
;
}
