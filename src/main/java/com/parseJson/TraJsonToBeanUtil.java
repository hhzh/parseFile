package com.parseJson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class TraJsonToBeanUtil {

    public static void main(String[] args) {
//		spliceJSON("E:/json.txt");
        writeClass();
    }

    public static String spliceJSON(String filePath) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String res = "";
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            bw = new BufferedWriter(new FileWriter("mapPut.txt"));
            String temp = null;
            String result = "";
            while (null != (temp = br.readLine())) {
                result += temp;
            }
            char[] arr = result.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (' ' != arr[i]) {
                    res += arr[i];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br || null != bw) {
                try {
                    br.close();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }

//	public static void writeClass(){
//		try {
//			JSONObject jsonObject=new JSONObject(spliceJSON("E:/json.txt"));
//			JSONArray jsonArray =jsonObject.getJSONArray("clientList");
//			System.out.println(jsonArray);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//	}

    public static void writeClass() {
        try {
            JSONTokener jsonTokener = new JSONTokener(spliceJSON("E:/json.txt"));
            JSONObject jsonObject = (JSONObject) jsonTokener.nextValue();

            while (jsonTokener.more()) {
                System.out.println(jsonTokener.nextValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
