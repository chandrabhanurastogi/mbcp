package com.ifli.mbcp.util;

/**
 * Represents all the constants that will be referred to in the MBCP application
 * domain model.
 * 
 * @author FL867
 * @version 1.0
 * @since 29 April 2013
 */
public class MBCPConstants
{
	public static final short		MALE				= 1;
	public static final short		FEMALE				= 2;

	public static final String	REFID_PREFIX		= "IL";
	public static final int		FIELD_WIDTH			= 8;
	
	public static final String APPNO_PREFIX = "P";
	
	public static final int YES = 1;
	public static final int NO = 0;
	
	public static final String	LEAD_DATE_FORMAT	= "MM/dd/yyyy";

	/*public interface EntityType
	{
		public static final int	INDIVIDUAL	= 1;
		public static final int	GROUP		= 2;
	}*/
	
	public interface PageType
	{
		public static final int	LEAD		= Lifecycle.CREATED.value;
		public static final int	NA			= Lifecycle.PENDING_NA.value;
		public static final int	BI			= Lifecycle.PENDING_BI.value;
		public static final int	PROPOSAL	= Lifecycle.PENDING_PROPSAL.value;
	}

	public static enum Lifecycle
	{

		CREATED((short)1, "Created"), 
		PENDING_NA((short)2, "Pending Need Analysis"), 
		PENDING_BI((short)3, "Pending Benefit Illustration"), 
		PENDING_PROPSAL((short)4,"Pending Proposal");

		private short	value;
		private String	displayValue;

		private Lifecycle(short value, String displayValue)
		{
			this.value = value;
			this.displayValue = displayValue;
		}

		public short getValue()
		{
			return value;
		}

		public String getDisplayValue()
		{
			return displayValue;
		}

		public static Lifecycle getLifecycleByState(short lifecycleState)
		{
			for (Lifecycle lifecycle : values())
			{
				if (lifecycleState == lifecycle.value)
				{
					return lifecycle;
				}
			}
			return null;

		}
		
	
	}

	
	public static String getLifecycleDisplayValue(short lifecycleState)
	{
		Lifecycle lifecycle = Lifecycle.getLifecycleByState(lifecycleState);
		return (lifecycle != null ) ? lifecycle.displayValue : null;

	}
	
	
	public static enum SearchBy
	{

		LEAD_ID(1, "Ref. Id"),
		FIRST_OR_LAST_NAME(2, "First/Last Name"),
		PRODUCT(10, "Product"),
		LEAD_STATUS(3, "Lead status"),
		MOBILE_NO(4, "Mobile Number"),
		BDM_CODE(5, "BDM Code"),
		BMRM_CODE(6, "BM/RM Code"),
		LEAD_GEN_CODE(7, "Lead Gen. / Advisor Code"),
		LEAD_CREATED_DATE(8, "Date Lead created"),
		PENDING_STAGE(9, "Pending Stage");

		private int		value;
		private String	displayValue;

		private SearchBy(int value, String displayValue)
		{
			this.value = value;
			this.displayValue = displayValue;
		}

		public int getValue()
		{
			return value;
		}

		public String getDisplayValue()
		{
			return displayValue;
		}

		public static SearchBy getSearchByField(int searchType)
		{
			for (SearchBy searchBy : values())
			{
				if (searchType == searchBy.value)
				{
					return searchBy;
				}
			}
			return null;

		}
	}
}
