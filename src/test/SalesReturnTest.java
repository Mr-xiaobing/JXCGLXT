import dao.GoodsDao;
import dao.SalesReturnDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Pager;
import pojo.SalesReturn;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class SalesReturnTest {
    private  SalesReturnDao salesReturnDao ;
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
       salesReturnDao = sqlSession.getMapper(SalesReturnDao.class);
    }


    @Test
    public void findByPager(){
        //          查
        Pager<SalesReturn> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<SalesReturn> list =salesReturnDao.findByPager(pager);
        for (SalesReturn salesReturn: list) {
            System.out.println("已经完成的出售的订单号："+salesReturn.getSrNo());
        }
        //        统计功能
        int count =  salesReturnDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
    }

    @Test
    public void add(){
        //        增
        LocalDateTime localDateTime = LocalDateTime.now();
        SalesReturn salesReturn = new SalesReturn(10018,10002,800,45,localDateTime,"管理员",10007,"一笔大单",10011);
        boolean state1 =salesReturnDao.add(salesReturn);
        if (state1){
            System.out.println("增加成功");
        }
    };

    @Test
    public void update(){
        //        改
        LocalDateTime localDateTime = LocalDateTime.now();
        SalesReturn salesReturn1 = new SalesReturn(10010,10002,800,45,localDateTime,"管理员",10007,"修改后的一笔大单",10011);
        boolean state2 =salesReturnDao.update(salesReturn1);
        if (state2){
            System.out.println("修改成功");
        }
    };

    @Test
    public void delete(){
        //        删
        LocalDateTime localDateTime = LocalDateTime.now();
        SalesReturn salesReturn1 = new SalesReturn(10010,10002,800,45,localDateTime,"管理员",10007,"修改后的一笔大单",10011);
        boolean state3 = salesReturnDao.delete(salesReturn1);
        if (state3){
            System.out.println("删除成功");
        }
    };

}
