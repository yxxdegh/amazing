/**  
* Title: MybatisTest.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年2月27日  
* @version 1.0  
*/  
package amazing;


import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yxx.amazing.dao.UserMapper;
import com.yxx.amazing.domain.User;

/**  
* Title: MybatisTest  
* Description:  
* @author yuanxx  
* @date 2018年2月27日  
*/
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:spring-mybatis.xml","classpath:mybatis-config.xml"})
@Transactional 
public class MybatisTest {
	@Autowired
	private UserMapper userMapper;
	@Test
    public void get() {
    	User u=userMapper.getUserById(89);
    	System.out.println(u);
	}
	
	
	@Test
    public void deleteBatch() throws IOException {
    	ArrayList<Integer> list=new ArrayList<>();
    		list.add(95);
    		list.add(96);
    	Integer count=userMapper.deleteBatch(list);
    	System.out.println("成功删除"+count+"条数据");
	}
	
	@Test
	public void test1(){
		ArrayList<String> list1=new ArrayList<>();
		list1.add("1");
		list1.add("2");
		ArrayList<Integer> list2=new ArrayList<>();
		list2.add(1);
		
		
	
	System.out.println( list1.removeAll(list2));
	System.out.println(list1);
	
		
	}
}

