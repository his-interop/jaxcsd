package zw.co.hitrac.jaxcsd.api.query;

import java.io.Serializable;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.CsdMarshalable;
import zw.co.hitrac.jaxcsd.api.domain.OtherID;
import zw.co.hitrac.jaxcsd.api.domain.PushRequest;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import zw.co.hitrac.jaxcsd.api.domain.UniqueID;
import zw.co.hitrac.jaxcsd.api.marshal.RequestParamsMarshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class RequestParams implements CsdMarshalable{
    
    private UniqueID uniqueID;
    private OtherID otherID;
    private String commonName;
    private CodedType codedType;
    private Address address;
    private Integer start;
    private Integer max;
    private Record record;
    private PushRequest pushRequest;

    public UniqueID getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(UniqueID uniqueID) {
        this.uniqueID = uniqueID;
    }

    public OtherID getOtherID() {
        return otherID;
    }

    public void setOtherID(OtherID otherID) {
        this.otherID = otherID;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public CodedType getCodedType() {
        return codedType;
    }

    public void setCodedType(CodedType codedType) {
        this.codedType = codedType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public PushRequest getPushRequest() {
        return pushRequest;
    }

    public void setPushRequest(PushRequest pushRequest) {
        this.pushRequest = pushRequest;
    }

    public String marshal() {
      return RequestParamsMarshaler.get().marshal(this);
    }

    public String marshal(String elementName) {
       return RequestParamsMarshaler.get().marshal(this, elementName);
    }
    
    
}
