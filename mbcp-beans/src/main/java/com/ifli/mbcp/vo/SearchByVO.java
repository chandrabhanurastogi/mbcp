package com.ifli.mbcp.vo;

public class SearchByVO
{

	private int		searchById;
	private String	searchByName;

	public String getSearchByName()
	{
		return searchByName;
	}

	public void setSearchByName(String searchByName)
	{
		this.searchByName = searchByName;
	}

	public int getSearchById()
	{
		return searchById;
	}

	public void setSearchById(int searchById)
	{
		this.searchById = searchById;
	}

	public SearchByVO(int searchById, String searchByName)
	{
		super();
		this.searchById = searchById;
		this.searchByName = searchByName;
	}

}
