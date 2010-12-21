package org.jsonunit;

public class JSONPathToken
{
	/**
	 * KYE
	 */
	private String key;
	
	/**
	 * -1 if object
	 * index if array
	 */
	private int index;

	public JSONPathToken(String key)
	{
		this(key, -1);
	}

	public JSONPathToken(String key, int index)
	{
		this.key = key;
		this.index = index;
	}

	public String getKey()
	{
		return key;
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}
}
