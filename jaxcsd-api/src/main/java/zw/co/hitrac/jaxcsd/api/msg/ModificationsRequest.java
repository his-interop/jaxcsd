package zw.co.hitrac.jaxcsd.api.msg;

/**
 *
 * @author Charles Chigoriwa
 */
public class ModificationsRequest extends CsdRequest {

    private String lastModified;

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        String superToString=super.toString();
        return superToString+"\n" +"ModificationsRequest{" + "lastModified=" + lastModified + '}';
    }
}
