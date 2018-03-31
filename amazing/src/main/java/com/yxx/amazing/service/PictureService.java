package com.yxx.amazing.service;

import java.util.List;
import java.util.Map;

import com.yxx.amazing.domain.Picture;

public interface PictureService { 
		
		// 显示所有图片(可以进行多条件查询)
		List<Picture> listAllPictureByMap(Map<String,Object> map);
		
		// 添加图片
		void savePicture(Picture picture);
}
