package zw.co.hitrac.jaxcsd.api.marshal;

import java.io.Serializable;

/**
 *
 * @author charles
 */
public abstract class Marshaller<T> implements Serializable {

    public abstract String marshal(T t);

    public String marshal(T t, String elementName) {
        return marshal(t);
    }
;
}
