package com.w.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");

        get.addHeader("cookie", "zsxq_access_token=7A7329DC-CAA0-8EA6-F483-CABF34775CED_F581A6278B8C077A; zsxqsessionid=7096e5dfafe217716fe17bbd036fd5a5; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross={\"distinct_id\":\"212548418855441\",\"first_id\":\"188571c31ee18e-0ee2389ba302e1-7b515477-1327104-188571c31ef17ba\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg4NTcxYzMxZWUxOGUtMGVlMjM4OWJhMzAyZTEtN2I1MTU0NzctMTMyNzEwNC0xODg1NzFjMzFlZjE3YmEiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTI1NDg0MTg4NTU0NDEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"212548418855441\"},\"$device_id\":\"188571c31ee18e-0ee2389ba302e1-7b515477-1327104-188571c31ef17ba\"}; abtest_env=beta");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post=new HttpPost("https://api.zsxq.com/v2/topics/214485428842251/comments");
        post.addHeader("cookie", "zsxq_access_token=7A7329DC-CAA0-8EA6-F483-CABF34775CED_F581A6278B8C077A; zsxqsessionid=7096e5dfafe217716fe17bbd036fd5a5; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross={\"distinct_id\":\"212548418855441\",\"first_id\":\"188571c31ee18e-0ee2389ba302e1-7b515477-1327104-188571c31ef17ba\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg4NTcxYzMxZWUxOGUtMGVlMjM4OWJhMzAyZTEtN2I1MTU0NzctMTMyNzEwNC0xODg1NzFjMzFlZjE3YmEiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTI1NDg0MTg4NTU0NDEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"212548418855441\"},\"$device_id\":\"188571c31ee18e-0ee2389ba302e1-7b515477-1327104-188571c31ef17ba\"}; abtest_env=beta");
        post.addHeader("Content-Type", "application/json;charset=utf8");
        String paramJson="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"test_1\\n\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("texy/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
