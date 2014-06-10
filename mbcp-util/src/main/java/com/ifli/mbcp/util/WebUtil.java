package com.ifli.mbcp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * 
 * @author Niranjan
 * @since 08 May 2013
 * @version 1.0
 */
public class WebUtil
{
	private static final Logger		logger	= LoggerFactory.getLogger(WebUtil.class);
	private static DozerBeanMapper	mapper;

	/**
	 * Initializes the default DozerMapper , picking the mapping xml file from
	 * mbcp-util
	 */
	public static void init()
	{
		if (mapper == null)
		{
			List<String> myMappingFiles = new ArrayList<String>();
			myMappingFiles.add("dozerBeanMapping.xml");

			mapper = new DozerBeanMapper();
			mapper.setMappingFiles(myMappingFiles);

		}
	}

	/**
	 * Copy properties using default DozerMapper
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static <T> T copyProperties(Object source, T target)
	{
		return copyProperties(source, target, null);
	}

	/**
	 * Copy properties contextually using default DozerMapper, mapId specifies
	 * the context
	 * 
	 * @param source
	 * @param target
	 * @param mapId
	 * @return
	 */
	public static <T> T copyProperties(Object source, T target, String mapId)
	{
		init();
		mapper.map(source, target, mapId);
		return target;
	}

	/**
	 * Copy properties using the given DozerMapper
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static <T> T copyProperties(DozerBeanMapper myMapper, Object source, T target)
	{
		return copyProperties(myMapper, source, target, null);
	}

	/**
	 * Copy properties contextually using the given DozerMapper, mapId specifies
	 * the context
	 * 
	 * @param source
	 * @param target
	 * @param mapId
	 * @return
	 */
	public static <T> T copyProperties(DozerBeanMapper myMapper, Object source, T target, String mapId)
	{
		myMapper.map(source, target, mapId);
		return target;
	}

	/**
	 * Returns the query string defined on  liferay page (in control panel while creating)  as ParameterMap  
	 * @param renderRequest
	 * @return
	 */
	public static Map<String, String> getPageParamMap(PortletRequest renderRequest)
	{
		Map<String, String> paramMap = new HashMap<String, String>();
		ThemeDisplay themeDisplay = getThemeDisplay(renderRequest);
		try
		{
			Layout layout = themeDisplay.getLayout();
			String queryString = layout.getTypeSettingsProperties().get("query-string");
			String[] params = StringUtils.splitByWholeSeparator(queryString, StringPool.AMPERSAND);

			for (String p : params)
			{
				String[] str = StringUtils.splitByWholeSeparator(p, StringPool.EQUAL);
				paramMap.put(str[0], str[1]);
			}
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
		}

		return paramMap;
	}

	/**
	 * Utility method to access the ThemeDisplay object from any PortletRequest
	 * @param portletRequest
	 * @return
	 */
	public static ThemeDisplay getThemeDisplay(PortletRequest portletRequest)
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
		return themeDisplay;
	}

	/**
	 * Returns the original HttpServletRequest
	 * @param portletRequest
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest(PortletRequest portletRequest)
	{
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(portletRequest);
		httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
		return httpRequest;
	}
}
