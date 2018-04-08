package com.lanxu.rpc;

import com.amazonaws.services.opsworks.model.App;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年03月21 22:58
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RpcApplication.class)
@WebAppConfiguration
@Transactional()
public class BaseTest {
}