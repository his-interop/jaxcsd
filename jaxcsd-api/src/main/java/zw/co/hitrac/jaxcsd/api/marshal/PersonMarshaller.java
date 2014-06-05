package zw.co.hitrac.jaxcsd.api.marshal;

import zw.co.hitrac.jaxcsd.api.domain.Name;
import zw.co.hitrac.jaxcsd.api.domain.Person;

import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;
import zw.co.hitrac.jaxcsd.api.util.JaxCsdUtil;

/**
 *
 * @author Charles Chigoriwa
 */
public class PersonMarshaller extends Marshaller<Person> {

    private static final PersonMarshaller INSTANCE = new PersonMarshaller();

    private PersonMarshaller() {
    }

    @Override
    public String marshal(Person person, String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(elementName).append(">");
        if (person.getNames() != null && !person.getNames().isEmpty()) {
            for (Name name : person.getNames()) {
                sb.append(NameMarshaller.get().marshal(name));
            }
        }

        sb.append(ContactPointListMarshaller.get().marshal(person.getContactPoints()));
        sb.append(AddressListMarshaller.get().marshal(person.getAddresses()));
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

    public static PersonMarshaller get() {
        return INSTANCE;
    }
}
