import dao.ClientDao;
import dao.GoodsDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Client;
import pojo.Pager;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClientDaoTest {
    private ClientDao clientDao;
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
         clientDao =  sqlSession.getMapper(ClientDao.class);
    }

    @Test
//   查找出全部的数据  展示第一页的5行的数据
    public void findByPager(){
//          查
        Pager<Client> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<Client> list = clientDao.findByPager(pager);
        System.out.println("前五名客户展示如下:");
        for (Client client: list) {
            System.out.println("客户名："+client.getClient());
        }
//        统计功能
        int count =  clientDao.findTotalByPager(pager);
        System.out.println("客户总数："+count);
    }

    @Test
//    根据客户名字查找
    public void findByGoodsName(){
        Client client = new Client(0,"小",null,null,null);
        System.out.println("查找名字带有'小'的客户  结果如下:");
        Pager<Client> pager = new Pager<>();
        pager.setCondition(client);
        List<Client> list  =clientDao.findByPager(pager);
        for (Client client1:list) {
            System.out.println("成功找到:"+client1.getClient());
        }
    }

//    根据地址查找
    @Test
    public void findByAddress(){
        Client client = new Client(0,null,"上海",null,null);
        System.out.println("查找上海的客户  结果如下:");
        Pager<Client> pager = new Pager<>();
        pager.setCondition(client);
        List<Client> list  =clientDao.findByPager(pager);
        for (Client client1:list) {
            System.out.println("成功找到:"+client1.getClient());
        }
    }
//    新增客户
    @Test
    public void add(){
        //        增
        Client client1 = new Client(1,"刘先生","柳州","2420709800@qq.com","18778485555");
        boolean state1 = clientDao.add(client1);
        if (state1){
            System.out.println("添加成功");
        }
    };

    @Test
//    修改客户
    public void update(){
        //        改
        Client client2 = new Client(10013,"修改后的刘先生","柳州","2420709800@qq.com","18778485555");
        boolean state2 = clientDao.update(client2);
        if (state2){
            System.out.println("修改成功");
        }
    };

    @Test
//    删除客户
    public void delete(){
        //        删除
        Client client3 = new Client(10014,"修改后的刘先生","柳州","2420709800@qq.com","18778485555");
        boolean state3 = clientDao.delete(client3);
        if (state3){
            System.out.println("删除成功");
        }
    };

}
