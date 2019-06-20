package com.spring5.hibernate.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring5.hibernate.service.BookShopService;
/**
 * 
* @ClassName:  SpringHibernateTest 
* @version:（版本，具体版本信息自己来定） 
* @Description: （hibernate 测试） 
* @author: yewenbo （作者） 
* @date: 2019年6月20日上午10:37:52（日期）
 */
public class SpringHibernateTest {
	
	private ApplicationContext ctx = null;
	private BookShopService bookShopService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext5.xml");
		bookShopService = ctx.getBean(BookShopService.class);
	}
	@Test
	public void testBookShopService() {
		bookShopService.purchase("aa", "1001");
	}
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
