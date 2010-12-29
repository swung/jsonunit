package org.jsonunit.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.jsonunit.JSONDiff;
import org.jsonunit.JSONPath;
import org.jsonunit.JSONPathToken;
import org.junit.Test;

public class JSONUnitTest
{
	@Test
	public void testGetValueByPath_start_with_array() throws Exception
	{
		String json = readFile("src/org/jsonunit/test/test_start_with_array.json");

		assertEquals("yadan", (String) JSONPath.getValueByPath(json, "/[0]/name"));
		assertEquals("yadan", (String) JSONPath.getValueByPath(json, "/[0]/username"));
		assertEquals("yadan@baidu.com", (String) JSONPath.getValueByPath(json, "/[0]/email"));
		assertEquals("xiaoshenyang", (String) JSONPath.getValueByPath(json, "/[1]/name"));
		assertEquals("xiaoshenyang", (String) JSONPath.getValueByPath(json, "/[1]/username"));
		assertEquals("xiaoshenyang@baidu.com", (String) JSONPath.getValueByPath(json, "/[1]/email"));
	}

	@Test
	public void testGetValueByPath_normal() throws Exception
	{
		String json = readFile("src/org/jsonunit/test/test_normal.json");

		assertEquals(1, JSONPath.getValueByPath(json, "/Image/A"));
		assertEquals(600, JSONPath.getValueByPath(json, "/Image/Height"));
		assertEquals(800, JSONPath.getValueByPath(json, "/Image/Width"));
		assertEquals("View from 15th Floor", JSONPath.getValueByPath(json, "/Image/Title"));
		assertEquals("http://scd.mm-b1.yimg.com/image/481989943", JSONPath.getValueByPath(json, "/Image/Thumbnail/Url"));
		assertEquals(125, JSONPath.getValueByPath(json, "/Image/Thumbnail/Height"));
		assertEquals("100", JSONPath.getValueByPath(json, "/Image/Thumbnail/Width"));
		assertEquals(116, JSONPath.getValueByPath(json, "/Image/IDs[0]"));
		assertEquals(943, JSONPath.getValueByPath(json, "/Image/IDs[1]"));
		assertEquals(234, JSONPath.getValueByPath(json, "/Image/IDs[2]"));
		assertEquals(38793, JSONPath.getValueByPath(json, "/Image/IDs[3]"));
	}

	@Test
	public void testDiffSameFile() throws Exception
	{
		JSONObject json = new JSONObject(readFile("src/org/jsonunit/test/test_normal.json"));
		JSONObject json_same = new JSONObject(readFile("src/org/jsonunit/test/test_normal.json"));

		JSONDiff diff = new JSONDiff(json, json_same);

		assertTrue(diff.seam());
	}

	@Test
	public void testDiffSimilarFile() throws Exception
	{
		JSONObject json = new JSONObject(readFile("src/org/jsonunit/test/test_normal.json"));
		JSONObject json_similar = new JSONObject(readFile("src/org/jsonunit/test/test_normal_similar.json"));

		JSONDiff diff = new JSONDiff(json, json_similar);

		assertFalse(diff.seam());
		assertTrue(diff.similar());
	}

	@Test
	public void testGetDiffPath() throws Exception
	{
		JSONObject json = new JSONObject(readFile("src/org/jsonunit/test/test_normal.json"));
		JSONObject json_similar = new JSONObject(readFile("src/org/jsonunit/test/test_normal_similar.json"));

		JSONDiff diff = new JSONDiff(json, json_similar);

		assertFalse(diff.seam());
		String[] ps = diff.getDiffPath();
		assertEquals("/Image/Width", ps[0]);
		assertEquals("/Image/Width", ps[1]);
	}

	@Test
	public void testGetPath() throws Exception
	{
		List<JSONPathToken> list = new ArrayList<JSONPathToken>();
		JSONPathToken t = new JSONPathToken("test1", 1);
		list.add(t);
		t = new JSONPathToken("test2", -1);
		list.add(t);
		t = new JSONPathToken("test3", 5);
		list.add(t);

		assertEquals("/test1[1]/test2/test3[5]", JSONPath.getPath(list));
	}

	@Test
	public void testGetPathList() throws Exception
	{
		List<JSONPathToken> list = JSONPath.getPathList("/test1[1]/test2/test3[5]");

		assertEquals("test1", list.get(0).getKey());
		assertEquals(1, list.get(0).getIndex());
		assertEquals("test2", list.get(1).getKey());
		assertEquals(-1, list.get(1).getIndex());
		assertEquals("test3", list.get(2).getKey());
		assertEquals(5, list.get(2).getIndex());
	}

	private String readFile(String file) throws Exception
	{
		FileReader reader = new FileReader(new File(file));
		BufferedReader br = new BufferedReader(reader);
		StringBuffer buffer = new StringBuffer();
		String line = br.readLine();
		while (line != null) {
			buffer.append(line);
			line = br.readLine();
		}

		return buffer.toString();
	}

}
