package zw.co.hitrac.jaxcsd.api.msg;

import java.io.Serializable;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class CsdRequest implements Serializable{
    
    protected String action;
    protected String messageId;
    protected String replyToAddress;
    protected String to;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getReplyToAddress() {
        return replyToAddress;
    }

    public void setReplyToAddress(String replyToAddress) {
        this.replyToAddress = replyToAddress;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "CsdRequest{" + "action=" + action + ", messageId=" + messageId + ", replyToAddress=" + replyToAddress + ", to=" + to + '}';
    }
    
}
