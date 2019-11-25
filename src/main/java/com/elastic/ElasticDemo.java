package com.elastic;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticDemo {

    public static void main(String[] args) throws UnknownHostException {
        //TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
        //        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.80.41"), 9200));
        //
        //GetResponse response = client.prepareGet("accounts", "name", "1").get();
        //System.out.println(response);
        //System.out.println(response.toString());

        for (int i = 40750; i <= 40758; i++) {
            System.out.println("error.code.biz."+i+"=");
        }

    }

}
