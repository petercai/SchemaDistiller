/*******************************************************************************
 * Copyright (c) 2010 Peter Cai
 * All rights reserved.
 *
 * ***************************************************************
 * Filename:    XGroup.java
 * Description: SchemaDistiller
 * Created by:  Peter Cai
 * Created on:  Aug 28, 2013
 ******************************************************************************/




package cai.peter.schema.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Peter Cai
 *
 */
public class xgroup
{
	protected String path;
	protected String order;
	protected List<String> items = new ArrayList<String>();
	protected List<xgroup> groups = new ArrayList<xgroup>();
	public xgroup(String order)
	{
		super();
		this.order = order;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	@Override
	public String toString()
	{
		String result = null;

		if(items.size()>1)
		{
			StringBuilder s = new StringBuilder();

			switch(( order ))
			{
			case "choice":
				s.append(path);
				s.append("(");
				s.append(Arrays.toString(items.toArray()).replaceAll(",", "|"));
				s.append(")");
				result = s.toString();
				break;
			case "all":
				s.append(path);
				s.append("<");
				s.append(Arrays.toString(items.toArray()).replaceAll(",", "|"));
				s.append(">");
				result = s.toString();
				break;
			}
		}
		return result;
	}

	public List<xgroup> getGroups()
	{
		return groups;
	}
	
	public void addGroup(xgroup group)
	{
		groups.add(group);
	}

	public List<String> getItems()
	{
		return items;
	}
	
	public void addItem(String item)
	{
		items.add(item);
	}

}
