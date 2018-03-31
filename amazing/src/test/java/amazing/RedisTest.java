/**  
* Title: RedisTest.java 
* Description:   
* Copyright: Copyright (c) 2018  
* Company: www.kaola100.com 
* @author yuanxx 
* @date 2018年3月1日  
* @version 1.0  
*/  
package amazing;

import org.junit.*;

import redis.clients.jedis.Jedis;

/**  
* Title: RedisTest  
* Description:  
* @author yuanxx  
* @date 2018年3月1日  
*/
public class RedisTest {

	 private Jedis jedis;

	    @Before
	    public void setJedis() {
	        // 连接redis服务器(在这里是连接本地的)
	        jedis = new Jedis("127.0.0.1", 6379);
	        System.out.println(jedis.ping());
	    }
	    @Test
	    public void testString() {
	    	// 存值
	       jedis.set("str1", "v1");
	       jedis.set("str2", "2");
	       // 取值
	       System.out.println(jedis.get("str1"));
	       // 删除
	       //jedis.del("str1");
	       //System.out.println(jedis.get("str1"));
	       // 值后面追加
	       jedis.append("str1", "v1");
	       System.out.println(jedis.get("str1"));
	       // 字符串长度
	       Long a=jedis.strlen("str1");
	       System.out.println(a);
	       // 如果值为数字，那么可以进行加减操作  
	       //Long incr = jedis.incr("str2");// 每次加1
	       //System.out.println(incr);
	       Long incrby = jedis.incrBy("str2", 4);// 每次加4
	       System.out.println(incrby);
	       // 每次减1
	       Long decr = jedis.decr("str2");
	       System.out.println(decr);
	       Long decrby = jedis.decrBy("str2",2);// 每次减2
	       System.out.println(decrby);
	    }
}
