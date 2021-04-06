package com.beautifulharborbackstage.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author zhangteng
 * @date: Created in 10:42 2021/4/1
 */
public class MapUtil {
    public static final String GET_URL = "http://restapi.amap.com/v3/geocode/geo?key=7a27e6cf6f5aafd30be1394b1bcc52b4&s=rsv3"+ "&address=上海市闵行区七莘路3599弄一号楼华商时代广场2层申洲酒店公寓";

    private static final String key = "7a27e6cf6f5aafd30be1394b1bcc52b4";
    /**
     * 根据地址查询经纬度
     *
     * @param address
     * @return
     */
    public static JSONObject getLngAndLat(String address) {
        JSONObject positionObj = new JSONObject();

        try {
            // 拼接请求高德的url
            String url = "http://restapi.amap.com/v3/geocode/geo?key="+key+"&s=rsv3&address="+address;
            // 请求高德接口
            String result = sendHttpGet(url);
            JSONObject resultJOSN = JSONObject.parseObject(result);
            System.out.println("高德接口返回原始数据：");
            System.out.println(resultJOSN);
            JSONArray geocodesArray = resultJOSN.getJSONArray("geocodes");
            if (geocodesArray.size() > 0) {
                String position = geocodesArray.getJSONObject(0).getString("location");
                String[] lngAndLat = position.split(",");
                String longitude = lngAndLat[0];
                String latitude = lngAndLat[1];
                positionObj.put("longitude", longitude);
                positionObj.put("latitude", latitude);
            }
            geocodesArray.getJSONObject(0).getString("location");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return positionObj;
    }

    /**
     * 发送Get请求
     *
     * @param url
     * @return
     */
    private static String sendHttpGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(3000)
                .setSocketTimeout(10000)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        String result = "";
        try {
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
            HttpEntity entity = closeableHttpResponse.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 接口调用 GET
     */
    public static void httpURLConectionGET() {
        try {
            URL url = new URL(GET_URL);    // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            System.out.println("Get=="+sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
        }
    }
}
