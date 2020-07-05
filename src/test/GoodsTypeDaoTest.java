import dao.GoodsTypeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.GoodsType;
import pojo.Pager;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class GoodsTypeDaoTest {
    private GoodsTypeDao goodsTypeDao;
    private SqlSession sqlSession;

    @Before
    public  void initGoodsTypeDao(){
        //        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = sqlSessionFactory.openSession();


//        实例化
        goodsTypeDao=  sqlSession.getMapper(GoodsTypeDao.class);
    }

    @Test
//    测试 goodsTypeDao接口
    public void testGoodsType(){
        System.out.println("<===========GoodsType测试================>");
        findByPager();
        addGoodsTypeDao();
        updateGoodsTypeDao();
        deleteGoodsTypeDao();
        System.out.println("<===============================>");
    }
    @Test
//   查找出全部的数据  展示第一页的5行的数据
    public void findByPager(){
        //          查
        Pager<GoodsType> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<GoodsType> list =goodsTypeDao.findByPager(pager);

        for (GoodsType goodsType: list) {
            System.out.println("标签名字："+goodsType.getType());
        }
        //        统计功能
        int count =  goodsTypeDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
    }

//    根据类型名字进行查找
    public void findByTypeName(){
        GoodsType goodsType = new GoodsType(0,"数码",null);

        Pager<GoodsType> pager = new Pager<>();

        List<GoodsType> list = goodsTypeDao.findByPager(pager);

    }
    @Test
    public void addGoodsTypeDao() {
        //        增
        LocalDateTime localDateTime = LocalDateTime.now();
        GoodsType goodsType1 = new GoodsType(10016,"黑科技",localDateTime);
        boolean state1 =  goodsTypeDao.add(goodsType1);
        if (state1){
            System.out.println("增加成功");
        }
    }

    @Test
    public void updateGoodsTypeDao(){
        //        改
        LocalDateTime localDateTime =LocalDateTime.now();
        GoodsType goodsType2 = new GoodsType(10014,"修改后的黑科技",localDateTime);
        boolean state2 =  goodsTypeDao.update(goodsType2);
        if (state2){
            System.out.println("修改成功");
        }
    }

    @Test
    public void deleteGoodsTypeDao(){
        //        删

        LocalDateTime localDateTime = LocalDateTime.now();
        GoodsType goodsType1 = new GoodsType(10016,"黑科技",localDateTime);
        boolean state3 = goodsTypeDao.delete(goodsType1);
        if (state3){
            System.out.println("删除成功");
        }

    }

}
