package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class HttpClient {
    /**
     * 向目的URL发送post请求
     *
     * @param url    目的url
     * @param params 发送的参数
     * @return AdToutiaoJsonTokenData
     */
    public static String sendPostRequest(String url, MultiValueMap<String, String> params) {
        RestTemplate client = new RestTemplate();
        //新建Http头，add方法可以添加参数
        HttpHeaders headers = new HttpHeaders();
        //设置请求发送方式
        HttpMethod method = HttpMethod.POST;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用String 类格式化（可设置为对应返回值格式的类）
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);

        return response.getBody();
    }

    /**
     * 向目的URL发送get请求
     *
     * @param url     目的url
     * @param params  发送的参数
     * @param headers 发送的http头，可在外部设置好参数后传入
     * @return String
     */
    public static String sendGetRequest(String url, MultiValueMap<String, String> params, HttpHeaders headers) {
        RestTemplate client = new RestTemplate();
        HttpMethod method = HttpMethod.GET;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用String 类格式化
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);
        return response.getBody();
    }

    /**
     * 需要參數的請求
     * 通过post请求返回json数据
     */
    public static JSONObject doPost(JSONObject date, String resUrl) {
        CloseableHttpClient client = HttpClients.createDefault();
//        // 要调用的接口方法
//        String url = "http://192.168.1.101:8080/getJson";
        HttpPost post = new HttpPost(resUrl);
        JSONObject jsonObject = null;
        try {
            StringEntity s = new StringEntity(date.toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);
            post.addHeader("content-type", "text/xml");
            CloseableHttpResponse res = client.execute(post);
            String response1 = EntityUtils.toString(res.getEntity());
            System.out.println(response1);
            if (res.getStatusLine().getStatusCode() == 200) {
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                jsonObject = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }


    /**
     * 不需要参数得http post请求
     *
     * @param resUrl
     * @return
     */
    public static String doPost(String resUrl) {
        CloseableHttpClient client = HttpClients.createDefault();
//        // 要调用的接口方法
//        String url = "http://192.168.1.101:8080/getJson";
        HttpPost post = new HttpPost(resUrl);
        JSONObject jsonObject = null;
        try {
            StringEntity s = new StringEntity("");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);
            post.addHeader("content-type", "text/xml");
            CloseableHttpResponse res = client.execute(post);
            String response1 = EntityUtils.toString(res.getEntity());
            System.out.println(response1);
            if (res.getStatusLine().getStatusCode() == 200) {
//                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
//                jsonObject = JSONObject.parseObject(result);
                return response1;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
