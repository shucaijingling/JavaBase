import com.shucai.dao.AccountDao;
import com.shucai.pojo.TestBean3;
import com.shucai.pojo.TestBean4;
import com.shucai.service.TransferService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {

    @Test
    public void testIOC() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        System.out.println(accountDao);


        Object testBean = context.getBean("testBean");
        System.out.println(testBean);


        Object testBean2 = context.getBean("testBean2");
        System.out.println(testBean2);

        TestBean3 testBean3 = (TestBean3) context.getBean("testBean3");
        System.out.println(testBean3);
//        context.close();

        TestBean4 testBean4 = (TestBean4) context.getBean("testBean4");
        System.out.println(testBean4);

    }

    @Test
    public void lazy() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Object lazyResult = context.getBean("lazyResult");
        System.out.println(lazyResult);

        context.close();
    }


    @Test
    public void test_FactoryBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Object companyBean = context.getBean("companyBean");
        System.out.println(companyBean);

        Object bean = context.getBean("&companyBean");
        System.out.println(bean);
    }

    /**
     * xml aop
     */
    @Test
    public void test_Aop() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TransferService bean = context.getBean(TransferService.class);
        bean.transfer("6029621011000", "6029621011001",100);
    }
}
