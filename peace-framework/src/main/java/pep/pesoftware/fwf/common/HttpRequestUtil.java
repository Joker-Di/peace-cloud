package pep.pesoftware.fwf.common;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/5/12.
 */
public class HttpRequestUtil {
    private static final String HTTP_ACCEPT = "accept";

    private static final String HTTP_ACCEPT_DEFAULT = "*/*";

    private static final String HTTP_ACCEPT_JSON = "application/json;charset=UTF-8";

    private static final String HTTP_USER_AGENT = "web-agent";

    private static final String HTTP_USER_AGENT_VAL = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)";

    private static final String HTTP_CONNECTION = "connection";

    private static final String HTTP_CONNECTION_VAL = "Keep-Alive";

    private static final String HTTP_CONTENT_TYPE = "Content-Type";

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty(HTTP_ACCEPT, HTTP_ACCEPT_DEFAULT);
            connection.setRequestProperty(HTTP_CONNECTION, HTTP_CONNECTION_VAL);
            connection.setRequestProperty(HTTP_USER_AGENT, HTTP_USER_AGENT_VAL);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpPost post = new HttpPost(url);
            post.setHeader(HTTP_CONTENT_TYPE, HTTP_ACCEPT_JSON);
            post.setEntity(new StringEntity(param, Charset.forName("UTF-8")));
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param params
     *            请求参数
     * @return 所代表远程资源的响应结果
     */

    public static String sendPost(String url, Map<String,String> params) {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpPost post = new HttpPost(url);
            post.setHeader(HTTP_CONTENT_TYPE, "application/x-www-form-urlencoded");
            List<NameValuePair> formParams = new ArrayList<NameValuePair>(); //构建POST请求的表单参数
            for(Map.Entry<String,String> entry : params.entrySet()){
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            post.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

