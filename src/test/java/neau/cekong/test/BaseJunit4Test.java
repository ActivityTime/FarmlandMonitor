package neau.cekong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-aop.xml", "classpath:spring/spring*"})
@TransactionConfiguration(transactionManager = "txManage", defaultRollback = true)
@Transactional//应用事务，这样测试就不会在数据库中留下痕迹
@WebAppConfiguration
public class BaseJunit4Test {
    @Test
    public void test(){}
}
