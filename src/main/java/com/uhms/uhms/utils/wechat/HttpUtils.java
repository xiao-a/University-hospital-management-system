package com.uhms.uhms.utils.wechat;

import com.uhms.uhms.component.MyX509TrustManager;
import com.uhms.uhms.utils.LogUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/**
 *
 */
public class HttpUtils {
    /**
     *  httpsRequest https的请求方式
     *  
     */
    public static String httpsRequest(String Url, String method, String outStr) {
        StringBuffer buffer = null;
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            TrustManager[] tm = {new MyX509TrustManager()};
            // 初始化
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 获取sslSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            // 建立连接
            URL url = new URL(Url);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            // 设置当前实例使用sslSocketFactory
            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.connect();
            // 先写入数据，再读取数据
            if (outStr != null) {
                OutputStream os = conn.getOutputStream();
                os.write(outStr.getBytes("UTF-8"));
                os.close();
            }
            // 读取服务端的内容
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
    /*
     * httpRequest http的请求方式
     */
    public static String httpRequest(String Url, String method) {
        StringBuffer buffer = null;
        try {
            // 建立连接
            URL url = new URL(Url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setDoOutput(true);
            conn.connect();
            // 读取服务端的内容
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }


    public static void main(String[] args) {
        String url = "https://www.baidu.com";
        String httpsRequest = httpsRequest(url, "GET", null);
        LogUtils.info(httpsRequest);
    }



}