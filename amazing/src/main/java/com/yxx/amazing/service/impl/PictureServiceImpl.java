package com.yxx.amazing.service.impl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxx.amazing.dao.PictureMapper;
import com.yxx.amazing.domain.Picture;
import com.yxx.amazing.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService{
	
	@Autowired
	private PictureMapper pictureMapper;
	
	@Override
	public List<Picture> listAllPictureByMap(Map<String, Object> map) {
		return pictureMapper.listAllPictureByMap(map);
	}

	/* (non-Javadoc)
	 * @see com.yxx.amazing.service.PictureService#savePicture(com.yxx.amazing.domain.Picture)
	 */
	@Override
	public void savePicture(Picture picture) {
		pictureMapper.savePicture(picture);
	}

	



}
