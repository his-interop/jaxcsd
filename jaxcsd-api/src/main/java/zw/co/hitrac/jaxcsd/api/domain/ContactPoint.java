package zw.co.hitrac.jaxcsd.api.domain;

import zw.co.hitrac.jaxcsd.api.marshal.ContactPointMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class ContactPoint implements CsdMarshalable {

    private CodedType codedType;
    private String equipment;
    private String purpose;
    private String certificate;
    private Marshaler<ContactPoint> marshaler = ContactPointMarshaler.get();

    public ContactPoint() {
    }

    public ContactPoint(CodedType codedType) {
        this.codedType = codedType;
    }

    public CodedType getCodedType() {
        return codedType;
    }

    public void setCodedType(CodedType codedType) {
        this.codedType = codedType;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public Marshaler<ContactPoint> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<ContactPoint> marshaler) {
        this.marshaler = marshaler;
    }
}
