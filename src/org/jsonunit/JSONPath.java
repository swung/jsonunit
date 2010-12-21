package org.jsonunit;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class implements very sub set of xpath
 * 
 * @author swung
 * 
 */
public class JSONPath
{
	public static Object getValueByPath(String json, String path)
	{
		try {
			JSONObject o = new JSONObject(json);
			return getValueByPath(o, path);
		} catch (JSONException e) {
			return null;
		}
	}

	public static Object getValueByPath(JSONObject object, String path)
	{
		JSONObject currentObject = object;
		List<JSONPathToken> list = getPathList(path);

		if (list != null) {
			int i = 0;
			int length = list.size();
			for (JSONPathToken nextToken : list) {
				try {
					if (nextToken.getIndex() < 0) {
						if (i < length - 1) {
							currentObject = currentObject.getJSONObject(nextToken.getKey());
						} else {
							return currentObject.get(nextToken.getKey());
						}
					} else {
						JSONArray ta = currentObject.getJSONArray(nextToken.getKey());
						if (i < length - 1) {
							currentObject = ta.getJSONObject(nextToken.getIndex());
							;
						} else {
							return ta.get(nextToken.getIndex());
						}
					}
				} catch (JSONException e) {
					return null;
				}
				i++;
			}
		}

		return null;
	}

	private static List<JSONPathToken> getPathList(String path)
	{
		if ((path == null) || path.length() == 0)
			return null;
		ByteArrayInputStream bis = new ByteArrayInputStream(path.getBytes());
		ANTLRInputStream input;
		try {
			input = new ANTLRInputStream(bis);
			JSONPathLexer lexer = new JSONPathLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			JSONPathParser parser = new JSONPathParser(tokens);
			parser.jsonpath();
			return parser.getTokenList();
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) throws Exception
	{
		// ByteArrayInputStream bis = new
		// ByteArrayInputStream("/Image/Width".getBytes());
		// ANTLRInputStream input = new ANTLRInputStream(bis);
		// JSONPathLexer lexer = new JSONPathLexer(input);
		// CommonTokenStream tokens = new CommonTokenStream(lexer);
		// JSONPathParser parser = new JSONPathParser(tokens);
		// parser.jsonpath();
		// List<Object> list = parser.getTokenList();
		// System.out.println(list.size());
		// for (Object o : list) {
		// System.out.println(((JSONPathToken) o).getKey());
		// System.out.println(((JSONPathToken) o).getIndex());
		// }

		FileReader reader = new FileReader(new File("D:\\testpdb.json"));
		BufferedReader br = new BufferedReader(reader);
		StringBuffer buffer = new StringBuffer();
		String line = br.readLine();
		while (line != null) {
			buffer.append(line);
			line = br.readLine();
		}
		JSONObject json = new JSONObject(buffer.toString());
		Object res = getValueByPath(json, "/[0]/name");
		if (res instanceof Integer) {
			System.out.println(((Integer) res).intValue());
		}

//		Object res1 = getValueByPath(json, "/Image/IDs[2]");
//		System.out.println(res1);
//
//		Object res2 = getValueByPath(json, "/Image");
//		System.out.println(res2);
	}

}
