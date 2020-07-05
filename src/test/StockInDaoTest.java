import dao.GoodsDao;
import dao.StockInDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Pager;
import pojo.StockIn;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class StockInDaoTest {
    private StockInDao stockInDao;
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
        stockInDao = sqlSession.getMapper(StockInDao.class);
    }


    @Test
    public void findByPager(){
        //          查
        Pager<StockIn> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<StockIn> list =stockInDao.findByPager(pager);
        for (StockIn stockIn: list) {
            System.out.println("入货单号："+stockIn.getStorageNo());
        }
        //        统计功能
        int count =  stockInDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
    }

    @Test
    public void add(){
        //        增
        LocalDateTime localDateTime = LocalDateTime.now();
        StockIn stockIn = new StockIn(10037,10001,10015,200,localDateTime,"管理员","一笔大单");
        boolean state1 =stockInDao.add(stockIn);
        if (state1){
            System.out.println("增加成功");
        }
    };

    @Test
    public void update(){
        //        改
        LocalDateTime localDateTime = LocalDateTime.now();
        StockIn stockIn1 = new StockIn(10034,10001,10015,200,localDateTime,"管理员","一笔大单");
        boolean state2 =stockInDao.update(stockIn1);
        if (state2){
            System.out.println("修改成功");
        }
    };

    @Test
    public void delete(){
        //        删
        LocalDateTime localDateTime = LocalDateTime.now();
        StockIn stockIn1 = new StockIn(10034,10001,10015,200,localDateTime,"管理员","一笔大单");
        boolean state3 = stockInDao.delete(stockIn1);
        if (state3){
            System.out.println("删除成功");
        }
    };

}
