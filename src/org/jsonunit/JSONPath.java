package org.jsonunit;

import java.io.ByteArrayInputStream;
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
		if (json == null) {
			return null;
		} else {
			json = json.trim();
		}

		try {
			if (json.startsWith("{")) {
				JSONObject o = new JSONObject(json);
				return getValueByPath(o, path);
			} else if (json.startsWith("[")) {
				JSONArray a = new JSONArray(json);
				return getValueByPath(a, path);
			} else {
				return null;
			}
		} catch (JSONException e) {
			return null;
		}
	}

	public static Object getValueByPath(JSONArray array, String path)
	{
		JSONArray currentArray = array;

		List<JSONPathToken> list = getPathList(path);
		if (list != null) {
			int i = 0;
			int length = list.size();
			JSONPathToken t = list.get(0);
			while ((t.getIndex() >= 0) && i < length) {
				i++;
				t = list.get(i);
			}

			int j = 0;
			for (; j < i - 1; j++) {
				try {
					currentArray = currentArray.getJSONArray(t.getIndex());
				} catch (JSONException e) {
					return null;
				}
				j++;
				t = list.get(j);
			}

			t = list.get(i - 1);
			List<JSONPathToken> newlist = list.subList(j + 1, length);
			try {
				return getValueByPath(currentArray.getJSONObject(t.getIndex()), getPath(newlist));
			} catch (JSONException e) {
				return null;
			}
		}
		return null;
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

	public static String getPath(List<JSONPathToken> list)
	{
		StringBuffer buf = new StringBuffer();

		for (JSONPathToken token : list) {
			if (token.getIndex() < 0) {
				buf.append("/" + token.getKey());
			} else {
				buf.append("/" + token.getKey() + "[" + token.getIndex() + "]");
			}
		}

		return buf.toString();
	}

	public static List<JSONPathToken> getPathList(String path)
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

}
