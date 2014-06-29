package zw.co.hitrac.jaxcsd.api.marshal;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;
import static zw.co.hitrac.jaxcsd.api.util.CsdElementConstants.*;

/**
 *
 * @author Charles Chigoriwa
 */
public class ContactPointListMarshaler extends Marshaler<List<ContactPoint>> {

    private final static ContactPointListMarshaler INSTANCE = new ContactPointListMarshaler();

    private ContactPointListMarshaler() {
    }

    @Override
    public String marshal(List<ContactPoint> contactPoints, String elementName) {
        StringBuilder sb = new StringBuilder();
        for (ContactPoint contactPoint : contactPoints) {
            sb.append(contactPoint.marshal(elementName));
        }
        return sb.toString();
    }

    @Override
    public String marshal(List<ContactPoint> contactPoints) {
        return marshal(contactPoints, CONTACT_POINT);
    }

    public static ContactPointListMarshaler get() {
        return INSTANCE;
    }
}
