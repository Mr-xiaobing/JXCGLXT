import dao.GoodsDao;
import dao.StockOutDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Pager;
import pojo.StockOut;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class StockOutDaoTest {
    private StockOutDao stockOutDao;
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
        stockOutDao = sqlSession.getMapper(StockOutDao.class);
    }


    @Test
    public void findByPager(){
        //          查
        Pager<StockOut> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<StockOut> list =stockOutDao.findByPager(pager);
        for (StockOut stockOut: list) {
            System.out.println("出货单号："+stockOut.getStockOutNo());
        }
        //        统计功能
        int count =  stockOutDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
    }

    @Test
    public void add(){
        //        增
        LocalDateTime localDateTime = LocalDateTime.now();
        StockOut stockOut = new StockOut(10037,10001,10015,200,localDateTime,"管理员","一笔大单");
        boolean state1 =stockOutDao.add(stockOut);
        if (state1){
            System.out.println("增加成功");
        }
    };

    @Test
    public void update(){
        //        改
        LocalDateTime localDateTime = LocalDateTime.now();
        StockOut  stockOut1 = new StockOut(10020,10001,10015,200,localDateTime,"管理员","修改后的一笔大单");
        boolean state2 = stockOutDao.update(stockOut1);
        if (state2){
            System.out.println("修改成功");
        }
    };

    @Test
    public void delete(){
        //        删
        LocalDateTime localDateTime = LocalDateTime.now();
        StockOut  stockOut1 = new StockOut(10020,10001,10015,200,localDateTime,"管理员","修改后的一笔大单");
        boolean state3 = stockOutDao.delete(stockOut1);
        if (state3){
            System.out.println("删除成功");
        }
    };

}
