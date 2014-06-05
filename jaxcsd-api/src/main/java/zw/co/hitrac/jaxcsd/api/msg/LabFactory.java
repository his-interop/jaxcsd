package zw.co.hitrac.jaxcsd.api.msg;

import java.text.ParseException;
import java.util.UUID;

/**
 *
 * @author Charles Chigoriwa
 */
public class LabFactory {

    public static void main(String[] args) throws ParseException {
        UUID uuid = UUID.randomUUID();
        
        //System.out.println(uuid.getMostSignificantBits());
        System.out.println(uuid.toString());
        String strUuid = uuid.toString();
        String[] components = strUuid.split("-");
        String x = "";
        for (int i = 0; i < components.length; i++) {
            x += Long.decode("0x"+components[i]);
            if(i<components.length-1){
               // x+=".";
            }
        }
        //System.out.println("2.25."+x);
        System.out.println(4<<1);
    }
}
