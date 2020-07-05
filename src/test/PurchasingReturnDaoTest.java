import dao.GoodsDao;
import dao.PurchasingReturnDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Pager;
import pojo.PurchasingReturn;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class PurchasingReturnDaoTest {
    private PurchasingReturnDao purchasingReturnDao ;
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
         purchasingReturnDao =sqlSession.getMapper(PurchasingReturnDao.class);
    }


    @Test
    public void findByPager(){
        //          查
        Pager<PurchasingReturn> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<PurchasingReturn> list =purchasingReturnDao.findByPager(pager);

        for (PurchasingReturn purchasingReturn: list) {
            System.out.println("完成的采购订单号："+purchasingReturn.getPrNo());
        }
        //        统计功能
        int count =  purchasingReturnDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
    }

    @Test
    public void add(){
        //        增

        LocalDateTime localDateTime = LocalDateTime.now();
        PurchasingReturn purchasingReturn = new PurchasingReturn(10003,10008,200,20.5,localDateTime,"管理员","王先生的订单",10011);
        boolean state1 =purchasingReturnDao.add(purchasingReturn);
        if (state1){
            System.out.println("增加成功");
        }
    };

    @Test
    public void update(){
        //        改
        LocalDateTime localDateTime = LocalDateTime.now();
        PurchasingReturn purchasingReturn1 = new PurchasingReturn(10003,10008,200,20.5,localDateTime,"管理员","王先生的订单",10011);
        boolean state2 = purchasingReturnDao.update(purchasingReturn1);
        if (state2){
            System.out.println("修改成功");
        }
    };

    @Test
    public void delete(){
        //        删
        LocalDateTime localDateTime = LocalDateTime.now();
        PurchasingReturn purchasingReturn1 = new PurchasingReturn(10003,10008,200,20.5,localDateTime,"管理员","王先生的订单",10011);
        boolean state3 = purchasingReturnDao.delete(purchasingReturn1);
        if (state3){
            System.out.println("删除成功");
        }
    };

}
