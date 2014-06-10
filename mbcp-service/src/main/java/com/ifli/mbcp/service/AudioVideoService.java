package com.ifli.mbcp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ifli.mbcp.domain.AudioVideo;

@Component
public interface AudioVideoService extends LookupService {
	
	/**
	 * gets list of audio video by criteria
	 * @param languageName
	 * @param type
	 * @param urlType
	 * @return {@link List}
	 * @throws Exception
	 * 
	 */
	public List<AudioVideo> getAudioVideoBy(String languageName, int type, String urlType) throws Exception;
	
	/**
	 * gets list of audio video by criteria
	 * @param languageId
	 * @param type
	 * @param urlType
	 * @return {@link List}
	 * @throws Exception
	 * 
	 */
	public List<AudioVideo> getAudioVideoBy(long languageId, int type, String urlType) throws Exception;

}
