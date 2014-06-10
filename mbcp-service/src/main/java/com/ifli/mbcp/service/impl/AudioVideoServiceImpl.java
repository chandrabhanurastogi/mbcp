package com.ifli.mbcp.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifli.mbcp.dao.GenericDAO;
import com.ifli.mbcp.domain.AudioVideo;
import com.ifli.mbcp.service.AudioVideoService;

/**
 * 
 * @author manoj
 * @since 4 June 2013
 * @version 1.0
 */

@Service(value = "audioVideoService")
@Transactional
public class AudioVideoServiceImpl  extends LookupServiceImpl implements AudioVideoService {

	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier(value="genericDAO")
	private GenericDAO genericDAO;
	
	@Override
	public List<AudioVideo> getAudioVideoBy(String languageName, int type,
			String urlType) throws Exception {
		
	DetachedCriteria detachedCriteria =	DetachedCriteria.forClass(AudioVideo.class).createAlias("language", "l")
	    .add(Restrictions.eq("l.name",languageName)).add(Restrictions.eq("urlType", urlType)).add(Restrictions.eq("type",type));
	
	List<AudioVideo> avList = genericDAO.findByCriteria(detachedCriteria);
	
	  return avList;
	}

	@Override
	public List<AudioVideo> getAudioVideoBy(long languageId, int type,
			String urlType) throws Exception {
		DetachedCriteria detachedCriteria =	DetachedCriteria.forClass(AudioVideo.class).createAlias("language", "l")
			    .add(Restrictions.eq("l.id",languageId)).add(Restrictions.eq("urlType", urlType)).add(Restrictions.eq("type",type));
		
		List<AudioVideo> avList = genericDAO.findByCriteria(detachedCriteria);
		
		return avList;
	}


}
