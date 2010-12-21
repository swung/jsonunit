package org.jsonunit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class Test
{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		FileReader reader = new FileReader(new File("D:\\test.json"));
		BufferedReader br = new BufferedReader(reader);
		StringBuffer buffer = new StringBuffer();
		String line = br.readLine();
		while (line != null) {
			buffer.append(line);
			line = br.readLine();
		}
		
		JSONObject json = new JSONObject(buffer.toString());
		JSONObject image = json.getJSONObject("Image");
		System.out.println(image.getString("Width"));
		JSONObject thumbnail = image.getJSONObject("Thumbnail");
		System.out.println(thumbnail.getString("Url"));
		JSONArray ids = image.getJSONArray("IDs");
		System.out.println(ids.length());
		System.out.println(ids.get(0));
//		System.out.println(width.getString("Width"));
	}

}
