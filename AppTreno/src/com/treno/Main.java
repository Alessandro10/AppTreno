package com.treno;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Main {
	public static void main(String[] args) {

		String sURL = "https://www.lefrecce.it/msite/api/solutions?origin=Bologna%20Centrale&destination=S.%20SEVERO&arflag=A&adate=06/11/2017&atime=06/11/2017&adultno=1&childno=0&direction=A&frecce=false&onlyRegional=false5D"
				+ ""; // just a string

		// Connect to the URL using java's native library
		URL url;
		try {
			url = new URL(sURL);

			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.connect();

			// Convert to a JSON object to print data
			JsonParser jp = new JsonParser(); // from gson
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); // Convert the input
																									// stream to a json
																									// element
			// JsonObject rootobj = root.getAsJsonObject(); // May be an array, may be an
			// object.
			JsonArray rootobj = root.getAsJsonArray();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
