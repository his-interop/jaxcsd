package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Name;
import zw.co.hitrac.jaxcsd.api.domain.Person;

import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class PersonMarshaler extends Marshaler<Person> {

    private static final PersonMarshaler INSTANCE = new PersonMarshaler();

    private PersonMarshaler() {
    }

    @Override
    public String marshal(Person person, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(">");
        if (person.getNames() != null && !person.getNames().isEmpty()) {
            for (Name name : person.getNames()) {
                sb.append(NameMarshaler.get().marshal(name));
            }
        }

        sb.append(ContactPointListMarshaler.get().marshal(person.getContactPoints()));
        sb.append(AddressListMarshaler.get().marshal(person.getAddresses()));
        if (person.getGender() != null) {
            sb.append(getInlineXmlElement("gender", person.getGender()));
        }
        
        if(person.getDateOfBirth()!=null){
            sb.append(getInlineXmlElement("dateOfBirth", JaxCsdUtil.toIsoShortDateFormatString(person.getDateOfBirth())));
        }
        sb.append("</").append(elementName).append(">");
        return sb.toString();
    }

    @Override
    public String marshal(Person person) {
        return marshal(person, "demographic");
    }

    public static PersonMarshaler get() {
        return INSTANCE;
    }
}
