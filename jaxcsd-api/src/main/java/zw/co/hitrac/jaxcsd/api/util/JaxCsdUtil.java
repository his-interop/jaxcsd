package zw.co.hitrac.jaxcsd.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import zw.co.hitrac.jaxcsd.api.JaxcsdRuntimeException;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import static zw.co.hitrac.jaxcsd.api.msg.InlineXmlElementFactory.getInlineXmlElement;

/**
 *
 * @author Charles Chigoriwa
 */
public class JaxCsdUtil {

    public static String toIsoDateFormat(Date date) {

        TimeZone timeZone = TimeZone.getDefault();
        boolean utc = TimeZone.getTimeZone("UTC").equals(timeZone)
                || TimeZone.getTimeZone("GMT").equals(timeZone);

        String pattern = utc ? "yyyy-MM-dd'T'HH:mm:ss'Z'" : "yyyy-MM-dd'T'HH:mm:ssZ";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        format.setTimeZone(timeZone);

        StringBuilder buffer = new StringBuilder(format.format(date));
        if (!utc) {
            buffer.insert(buffer.length() - 2, ':');
        }

        return buffer.toString();
    }

    public static String toIsoShortDateFormatString(Date date) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        StringBuilder buffer = new StringBuilder(format.format(date));
        return buffer.toString();
    }

    public static Date toDateFromIsoShortString(String string) {
        try {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.parse(string);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String inputStreamToString(InputStream inputStream) throws IOException {
        StringWriter sw = new StringWriter();
        int c;
        InputStream in = inputStream;
        while ((c = in.read()) != -1) {
            sw.write(c);
        }
        return sw.toString();
    }

    public static String parseHttpEntity(HttpEntity httpEntity) throws IOException {
        StringWriter sw = new StringWriter();
        int c;
        InputStream in = httpEntity.getContent();
        while ((c = in.read()) != -1) {
            sw.write(c);
        }
        return sw.toString();
    }

    public static JaxcsdResponse executeXmlPost(String httpBody, String httpAddress) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(httpAddress);
            HttpEntity httpEntity = new StringEntity(httpBody);
            httpPost.setEntity(httpEntity);
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            HttpResponse response = httpclient.execute(httpPost);
            int statusCode=response.getStatusLine().getStatusCode();
            String reasonPhrase=response.getStatusLine().getReasonPhrase();
            String strResponseMessage = JaxCsdUtil.parseHttpEntity(new BufferedHttpEntity(response.getEntity()));
            httpclient.getConnectionManager().shutdown();
            return new JaxcsdResponse(statusCode,reasonPhrase, strResponseMessage);
        } catch (Exception ex) {
            throw new JaxcsdRuntimeException(ex);
        }
    }

    public static String executeGet(String httpAddress) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpPost = new HttpGet(httpAddress);
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            HttpResponse response = httpclient.execute(httpPost);
            String strResponseMessage = JaxCsdUtil.parseHttpEntity(new BufferedHttpEntity(response.getEntity()));
            httpclient.getConnectionManager().shutdown();
            return strResponseMessage;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toXml(String xmlLabel, List<String> items) {
        StringBuilder sb = new StringBuilder();
        if (items != null && !items.isEmpty()) {
            for (String item : items) {
                sb.append(getInlineXmlElement(xmlLabel, item));
            }
        }
        return sb.toString();
    }

    public static List<String> initItems(String elementValue) {
        List<String> items = new ArrayList<String>();
        items.add(elementValue);
        return items;
    }

    public static List<CodedType> initItems(CodedType codedType) {
        List<CodedType> items = new ArrayList<CodedType>();
        items.add(codedType);
        return items;
    }

    public static boolean isEmptyString(String string) {
        return (string == null || string.trim().length() == 0);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(toDateFromIsoShortString("2014-05-17"));
    }
}
