import dao.GoodsDao;
import dao.SalesDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Pager;
import pojo.Sales;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class SalesDaoTest {
    private SalesDao salesDao;
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
        salesDao = sqlSession.getMapper(SalesDao.class);
    }


    @Test
    public void findByPager(){
        //          查
        Pager<Sales> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<Sales> list =salesDao.findByPager(pager);

        for (Sales sales: list) {
            System.out.println("出售的订单号："+sales.getsNo());
        }
        //        统计功能
        int count =  salesDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
    }

    @Test
    public void add(){
        //        增
        LocalDateTime localDateTime = LocalDateTime.now();
        Sales sales = new Sales(10024,10002,800,45,localDateTime,"管理员",10007,"一笔大单",10011);
        boolean state1 =salesDao.add(sales);
        if (state1){
            System.out.println("增加成功");
        }
    };

    @Test
    public void update(){
        //        改
        LocalDateTime localDateTime = LocalDateTime.now();
        Sales sales1 = new Sales(10024,10002,800,45,localDateTime,"管理员",10007,"一笔大单",10011);
        boolean state2 =salesDao.update(sales1);
        if (state2){
            System.out.println("修改成功");
        }
    };

    @Test
    public void delete(){
        //        删
        LocalDateTime localDateTime = LocalDateTime.now();
        Sales sales1 = new Sales(10024,10002,800,45,localDateTime,"管理员",10007,"一笔大单",10011);
        boolean state3 = salesDao.delete(sales1);
        if (state3){
            System.out.println("删除成功");
        }
    };

}
