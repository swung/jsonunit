package org.jsonunit;

import java.util.Iterator;
import java.util.Stack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONDiff
{
	private JSONObject jo1;
	private JSONObject jo2;
	private Stack<JSONPathToken> stack1;
	private Stack<JSONPathToken> stack2;

	public JSONDiff(JSONObject jo1, JSONObject jo2)
	{
		this.jo1 = jo1;
		this.jo2 = jo2;
	}

	public boolean similar()
	{
		this.stack1 = new Stack<JSONPathToken>();
		this.stack2 = new Stack<JSONPathToken>();
		return compare(this.jo1, this.jo2, false);
	}

	public boolean seam()
	{
		this.stack1 = new Stack<JSONPathToken>();
		this.stack2 = new Stack<JSONPathToken>();
		return compare(this.jo1, this.jo2, true);
	}

	private boolean compare(JSONObject jo1, JSONObject jo2, boolean strict)
	{
		int l1 = jo1.length();
		int l2 = jo2.length();

		if (l1 != l2)
			return false;

		if (l1 == 0) {
			return true;
		}

		boolean res = true;
		Iterator it1 = jo1.sortedKeys();
		Iterator it2 = jo2.sortedKeys();

		while (it1.hasNext() && it2.hasNext()) {
			String key1 = (String) it1.next();
			String key2 = (String) it2.next();

			objectStack(key1, key2);

			if (!key1.equalsIgnoreCase(key2)) {
				return false;
			}

			Object o1;
			Object o2;
			try {
				o1 = jo1.get(key1);
				o2 = jo2.get(key2);
			} catch (JSONException e) {
				return false;
			}

			if ((o1 instanceof JSONObject) && (o2 instanceof JSONObject)) {
				res = compare((JSONObject) o1, (JSONObject) o2, strict);
			} else if ((o1 instanceof JSONArray) && (o2 instanceof JSONArray)) {
				res = compare((JSONArray) o1, (JSONArray) o2, strict);
			} else {
				if (strict) {
					res = o1.equals(o2);
				} else {
					res = o1.getClass().getName().equals(o2.getClass().getName());
				}
			}

			if (!res) {
				return false;
			} else {
				popStack();
			}
		}

		return res;
	}

	private boolean compare(JSONArray joa1, JSONArray joa2, boolean strict)
	{
		int l1 = joa1.length();
		int l2 = joa2.length();

		if (l1 != l2)
			return false;

		if (l1 == 0) {
			return true;
		}

		boolean res = true;
		for (int i = 0; i < l1; i++) {
			Object o1;
			Object o2;

			updateStack(i);

			try {
				o1 = joa1.get(i);
				o2 = joa2.get(i);
			} catch (JSONException e) {
				return false;
			}

			if ((o1 instanceof JSONObject) && (o2 instanceof JSONObject)) {
				res = compare((JSONObject) o1, (JSONObject) o2, strict);
			} else if ((o1 instanceof JSONArray) && (o2 instanceof JSONArray)) {
				res = compare((JSONArray) o1, (JSONArray) o2, strict);
			} else {
				if (strict) {
					res = o1.equals(o2);
				} else {
					res = o1.getClass().getName().equals(o2.getClass().getName());
				}
			}

			if (!res) {
				return false;
			}
		}

		return res;
	}

	private void objectStack(String key1, String key2)
	{
		this.stack1.push(new JSONPathToken(key1));
		this.stack2.push(new JSONPathToken(key2));
	}

	private void updateStack(int index)
	{
		JSONPathToken t1 = this.stack1.pop();
		t1.setIndex(index);
		this.stack1.push(t1);
		JSONPathToken t2 = this.stack2.pop();
		t2.setIndex(index);
		this.stack2.push(t2);
	}

	private void popStack()
	{
		this.stack1.pop();
		this.stack2.pop();
	}

	private String getStackPath(Stack<JSONPathToken> stack)
	{
		String path = "";

		while (!stack.isEmpty()) {
			JSONPathToken token = stack.pop();
			if (token.getIndex() > 0) {
				path = "/" + token.getKey() + "[" + token.getIndex() + "]" + path;
			} else {
				path = "/" + token.getKey() + path;
			}
		}

		return path;
	}

	public String[] getDiffPath()
	{
		String[] paths = new String[2];
		paths[0] = getStackPath(stack1);
		paths[1] = getStackPath(stack2);

		return paths;
	}

}
