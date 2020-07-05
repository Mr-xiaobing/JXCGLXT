import dao.GoodsDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Goods;
import pojo.Pager;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class GoodsDaoTest {
    private GoodsDao goodsDao;
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
        goodsDao =  sqlSession.getMapper(dao.GoodsDao.class);
    }

    @Test
//    测试goodsDao接口
    public  void testGoodsDao(){
        System.out.println("<===========GOODS测试================>");
        findByPager();
        addGoods();
        updateGoods();
        deleteGoods();
        System.out.println("<===============================>");
        System.out.println();
   }



    @Test
//   查找出全部的数据  展示第一页的5行的数据
    public void findByPager(){

        //         调用接口
        Pager<Goods> pager =  new Pager<>();
//        设置页码和显示的数量
        pager.setPage(1);
        pager.setSize(5);
//        打印一下
//        查找功能
        List<Goods> list = goodsDao.findByPager(pager);
        for (Goods goods: list
        ) {
            System.out.println("商品展示:"+goods.getGoodsName());
        }
//        统计功能
        int count =  goodsDao.findTotalByPager(pager);
        System.out.println("商品总数量："+count);
    }

//    根据商品名字查找商品
    @Test
    public void findByGoodsName(){
        Goods goods = new Goods(0,"电视",null,0,null,null,null);
        Pager<Goods> pager = new Pager<>();
        pager.setCondition(goods);
        List<Goods> list = goodsDao.findByPager(pager);
        System.out.println("查找名字带有'电视'的商品  结果如下:");
        for (Goods goods1:list
             ) {
            System.out.println("成功查找:"+goods1.getGoodsName());
        }

    }
//    根据商品类型查找商品
    @Test
    public void findByType(){
        Goods goods = new Goods(0,null,10001,0,null,null,null);
        Pager<Goods> pager = new Pager<>();
        pager.setCondition(goods);
        List<Goods> list = goodsDao.findByPager(pager);
        System.out.println("查找名字带有'电视'的商品  结果如下:");
        for (Goods goods1:list
        ) {
            System.out.println("成功查找:"+goods1.getGoodsName());
        }
    }

//    添加
    @Test
    public void addGoods(){
        //        插入功能

        Goods goods1 = new Goods(1,"手机",10001,10001,"9.5寸","<p>6.18特惠</P>","C:/Users/xiaobing/Desktop/img/Banana.jpg");
        boolean state1 =false;
        state1= goodsDao.add(goods1);
        if (state1)
        {
            System.out.println("添加成功");
        }
    }
//    修改
    @Test
    public void updateGoods(){
        //       修改功能
        Goods goods2 = new Goods(10018,"修改后的手机",10001,10001,"9.5寸","<p>6.18特惠</P>","C:/Users/xiaobing/Desktop/img/Banana.jpg");
        boolean state2 = goodsDao.update(goods2);
        if (state2)
        {
            System.out.println("修改成功");
        }
    }
//    删除
    @Test
    public void deleteGoods(){
        //        删除功能
        Goods goods2 = new Goods(10018,"修改后的手机",10001,10001,"9.5寸","<p>6.18特惠</P>","C:/Users/xiaobing/Desktop/img/Banana.jpg");

        boolean state3 = goodsDao.delete(goods2);
        if (state3){
            System.out.println("删除成功");
        }
    }
}
