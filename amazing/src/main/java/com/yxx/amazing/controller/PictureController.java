/**  
* Title: PictureController.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月1日  
* @version 1.0  
*/  
package com.yxx.amazing.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxx.amazing.domain.Picture;
import com.yxx.amazing.service.PictureService;

/**  
* Title: PictureController  
* Description:  
* @author yuanxx  
* @date 2018年3月1日  
*/
@Controller
@RequestMapping(value="/pages/picture")
public class PictureController {
	
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping(value="/listAllPicture.do" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listAllUser(int pageSize,int currentPage,Picture picture){
		// 定义封装返回结果的map
		Map<String,Object> resultMap=new HashMap<String,Object>();
		// 定义查询结果的list
		List<Picture> pictureList=new ArrayList<Picture>();
		// 定义封装查询参数的map
		Map<String,Object> map=new HashMap<String,Object>();
			Integer id = picture.getId();
			String pictureName = picture.getPictureName();
		if (null != id ) {
			map.put("id", id);
		}if (null != pictureName && "" != pictureName) {
			map.put("pictureName", pictureName);	
		}
			
		try {
			// 分页插件传入当前第几页currentPage和每页显示多少条pageSize
			PageHelper.startPage(currentPage,pageSize);
			pictureList=pictureService.listAllPictureByMap(map);
			// 通过PageInfo对象获取分页的各项信息
			PageInfo<Picture> info=new PageInfo<>(pictureList);
			Long totalCount= info.getTotal(); // 获取总条数
			resultMap.put("data", pictureList);
			resultMap.put("count", totalCount);// 总条数
			resultMap.put("msg", "1");
			resultMap.put("code", 0);
		} catch (Exception e) {
			resultMap.put("msg", "-100");
			e.printStackTrace();
		}
			return resultMap;
	}
	
	
	/*@RequestMapping("/upload")
	public String upload(@RequestParam("file") CommonsMultipartFile file ,HttpServletRequest request){
		//获取上传位置
		String path=request.getServletContext().getRealPath("");
		System.out.println(path);//D:\apache-tomcat-8.0.14\webapps\amazing
		//String path=request.getRealPath("/upload/picture");
		//获取文件名
		String fileName=file.getOriginalFilename();
		Picture picture = new Picture();
		picture.setPictureName(fileName);
		picture.setSrc("/upload/picture/"+fileName);
		pictureService.savePicture(picture);
		try {
			InputStream is=file.getInputStream();
			OutputStream os=new FileOutputStream(new File(path,fileName));
			int len=0;
			byte[] buffer=new byte[1024];
			while((len=is.read(buffer))!=-1){
				os.write(buffer,0,len);
				
			}
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:success.jsp";
	}*/
	
	@RequestMapping("/upload")  
	public String uploadImage(MultipartFile mFile) throws Exception{  
	    if(mFile!=null){  
	        // 物理路径  
	        String lujin="D:\\upload\\image\\";  
	        // 文件名称  
	        String oldImagename=mFile.getOriginalFilename();  
	        // 新的文件名称  
	        String newImagename=UUID.randomUUID()+oldImagename.substring(oldImagename.lastIndexOf('.'));  
	        File file = new File(lujin+newImagename);  
	        // 保存文件  
	        mFile.transferTo(file);  
	        Picture picture = new Picture();
			picture.setPictureName(newImagename);
			picture.setSrc("\\upload\\image\\"+newImagename);
			pictureService.savePicture(picture);
	    }  
	      
	    return "/success.jsp";  
	}  
}
