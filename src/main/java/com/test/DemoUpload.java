package com.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DemoUpload {
    public static void main(String[] args) throws IOException, InterruptedException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://10.100.1.96:30080/testimg/firstappend");
        HttpPost post2 = new HttpPost("http://10.100.1.96:30080/testimg/append");

        File file = new File("test.jpg");
        System.out.println(file.length());
        FileInputStream inputStream = new FileInputStream(file);
        String result = null;
        byte[] temp = new byte[6024];
        int i = 1;
        while (inputStream.read(temp) != -1) {
            System.out.println("---");
            if (i == 1) {
                MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
                multipartEntityBuilder.addBinaryBody("file", temp, ContentType.MULTIPART_FORM_DATA, "jpg");
                post.setEntity(multipartEntityBuilder.build());
                CloseableHttpResponse httpResponse = client.execute(post);
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    HttpEntity httpEntity = httpResponse.getEntity();
                    String message = EntityUtils.toString(httpEntity, "utf-8");
                    result = message;
                    System.out.println("first upload success:" + message);
                }
            } else {
                MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
                multipartEntityBuilder.addBinaryBody("file", temp, ContentType.MULTIPART_FORM_DATA, "jpg");
                multipartEntityBuilder.addTextBody("groupPath", result, ContentType.MULTIPART_FORM_DATA);
                post2.setEntity(multipartEntityBuilder.build());
                CloseableHttpResponse httpResponse = client.execute(post2);
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    HttpEntity httpEntity = httpResponse.getEntity();
                    String message = EntityUtils.toString(httpEntity, "utf-8");
                    System.out.println("upload success:" + message);
                }
            }
            i++;
            Thread.sleep(800);
        }

        //multipartEntityBuilder.addBinaryBody("file", inputStream, ContentType.MULTIPART_FORM_DATA, "txt");
        //multipartEntityBuilder.addTextBody("groupPath", "group1/M00/00/04/CmQBY1rBjjuEUovDAAAAADz4EAY184.txt", ContentType.MULTIPART_FORM_DATA);
        //post2.setEntity(multipartEntityBuilder.build());
        //CloseableHttpResponse httpResponse = client.execute(post2);
        //if (httpResponse.getStatusLine().getStatusCode() == 200) {
        //    HttpEntity httpEntity = httpResponse.getEntity();
        //    String message = EntityUtils.toString(httpEntity, "utf-8");
        //    System.out.println("upload success:" + message);
        //}
        //System.out.println(httpResponse);
        inputStream.close();
    }
}
