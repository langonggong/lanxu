package com.lanxu.rpc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@Rollback(true)
public class RpcApplicationTests extends BaseTest{

	@Test
	public void contextLoads() {
		BeanFactory bf=new XmlBeanFactory(new ClassPathResource("test.xml"));
	}

	@Test
	public void daoTest(){

	}

}
