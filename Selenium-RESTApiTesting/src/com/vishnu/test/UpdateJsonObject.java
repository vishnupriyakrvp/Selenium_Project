package com.vishnu.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UpdateJsonObject{
@Test
public void aptTesting() throws Exception {
	
	HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead

	try {
	HttpPost request = new HttpPost("http://yoururl");
	StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
	request.addHeader("content-type", "application/x-www-form-urlencoded");
	request.setEntity(params);
	HttpResponse response = httpClient.execute(request);

	
		

			JSONObject obj = new JSONObject(response);
			String responseCode = obj.getString("status");
			System.out.println("status : " + responseCode);

			JSONArray arr = obj.getJSONArray("results");
			for (int i = 0; i < arr.length(); i++) {
				String placeid = arr.getJSONObject(i).getString("place_id");
				System.out.println("Place id : " + placeid);
				String formatAddress = arr.getJSONObject(i).getString("formatted_address");
				System.out.println("Address : " + formatAddress);

				// validating Address as per the requirement
				if (formatAddress.equalsIgnoreCase("Chicago, IL, USA")) {
					System.out.println("Address is as Expected");
				} else {
					System.out.println("Address is not as Expected");
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
