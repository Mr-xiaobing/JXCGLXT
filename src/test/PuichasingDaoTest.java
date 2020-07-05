import dao.GoodsDao;
import dao.PurchasingDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Pager;
import pojo.Purchasing;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PuichasingDaoTest {
    private PurchasingDao purchasingDao;
    private SqlSession sqlSession;

    @Before
    public  void init(){
//        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //        开始调用
//        相当于把sql进行connection连接
        sqlSession = sqlSessionFactory.openSession();
//        通过反射进行 实例化
        purchasingDao = sqlSession.getMapper(PurchasingDao.class);
    }


    @Test
    public void findByPager(){
        //          查
        Pager<Purchasing> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<Purchasing> list =purchasingDao.findByPager(pager);

        LocalDateTime localDateTime = LocalDateTime.of(2017,1,10,0,0,0);

        System.out.println(localDateTime);
        Purchasing purchasing = new Purchasing(1,1,1,1,localDateTime,null,null,1);

        pager.setCondition(purchasing);
        List<Purchasing> list1 =   purchasingDao.findByPager(pager);

        for (Purchasing purchasing2:list1)
        {
            System.out.println("时间:"+purchasing2.getDateIn());
        }
        for (Purchasing purchasing1: list) {
            System.out.println("采购订单号："+purchasing.getpNo());
        }
        //        统计功能
        int count =  purchasingDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
    }

    @Test
    public void add(){
        //        增



        LocalDateTime localDateTime = LocalDateTime.now();
        Purchasing purchasing = new Purchasing(10022,10008,200,20.5,localDateTime,"管理员","刘先生的订单",10011);
        boolean state1 =purchasingDao.add(purchasing);
        if (state1){
            System.out.println("增加成功");
        }
    };

    @Test
    public void update(){
        //        改
        LocalDateTime localDateTime = LocalDateTime.now();
        Purchasing purchasing1 = new Purchasing(10021,10008,200,20.5,localDateTime,"管理员","修改后刘先生的订单",10011);

        boolean state2 = purchasingDao.update(purchasing1);
        if (state2){
            System.out.println("修改成功");
        }
    };

    @Test
    public void delete(){
        //        删
        LocalDateTime localDateTime = LocalDateTime.now();
        Purchasing purchasing1 = new Purchasing(10021,10008,200,20.5,localDateTime,"管理员","修改后刘先生的订单",10011);
        boolean state3 = purchasingDao.delete(purchasing1);
        if (state3){
            System.out.println("删除成功");
        }
    };

}
