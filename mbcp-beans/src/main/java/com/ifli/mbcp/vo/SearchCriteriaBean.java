package com.ifli.mbcp.vo;

/**
 * 
 * This Bean stores all the information regarding the search performed by the End user.
 * @author Niranjan
 * @since 2-Jun-2013
 * @version 1.0
 */
public class SearchCriteriaBean
{

	/**
	 * The attribute(column) on the Lead to search by 
	 */
	private int		searchById;
	
	/**
	 * The Value of the attribute(column)
	 */
	private String	searchText;
	
	/***
	 * The Page where the Search is performed. Ex. Lead Page, Need Analysis Page etc
	 */
	private int		pageType;
	
	/***
	 * The Kind of Lead to search for
	 */
	private String	leadType;
	
	/**
	 * The State of the Lead Entity to search for
	 */
	private int		lifecycleState;
	
	/**
	 * No. of records to fetch from DB
	 * -1 means no limit (fetch all results)
	 * This is for pagination purpose
	 */
	private int		fetchSize = -1; 
	
	/**
	 * index of the record in search results.
	 *  -1 means fetch results from very first record
	 *  This is for pagination purpose
	 */
	private int		start = -1; 

	/**
	 * The name of the view (jsp file) to display search results
	 */
	private String view;
	
	public static final  String VIEW_EXT = ".jsp"; 
	
	/**
	 * Holds the validation state of the SerachCritria provided by End User
	 */
	private boolean	success;

	
	
	public int getSearchById()
	{
		return searchById;
	}

	public void setSearchById(int searchById)
	{
		this.searchById = searchById;
	}

	public String getSearchText()
	{
		return searchText;
	}

	public void setSearchText(String searchText)
	{
		this.searchText = searchText;
	}

	public int getPageType()
	{
		return pageType;
	}

	public void setPageType(int pageType)
	{
		this.pageType = pageType;
	}

	public String getLeadType()
	{
		return leadType;
	}

	public void setLeadType(String leadType)
	{
		this.leadType = leadType;
	}

	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public int getLifecycleState()
	{
		return lifecycleState;
	}

	public void setLifecycleState(int lifecycleState)
	{
		this.lifecycleState = lifecycleState;
	}

	public int getFetchSize()
	{
		return fetchSize;
	}

	public void setFetchSize(int fetchSize)
	{
		this.fetchSize = fetchSize;
	}

	public int getStart()
	{
		return start;
	}

	public void setStart(int start)
	{
		this.start = start;
	}

	public String getView()
	{
		return view + VIEW_EXT;
	}

	public void setView(String view)
	{
		this.view = view;
	}

}
