import dao.GoodsDao;
import dao.ProviderDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Pager;
import pojo.Provider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProviderDaoTest {
    private ProviderDao providerDao;
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
        //        实例化
       providerDao  = sqlSession.getMapper(ProviderDao.class);
    }


    @Test
    public void findByPager(){
        //          查
        Pager<Provider> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<Provider> list =providerDao.findByPager(pager);

        for (Provider provider: list) {
            System.out.println("供应商名字："+provider.getProvider());
        }
        //        统计功能
        int count =  providerDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
    }

    @Test
    public void add(){
        //        增
        Provider provider = new Provider(10025,"柳州供应商","广西柳州","刘先生","24207069800@qq.com","18778493825");
        boolean state1 = providerDao.add(provider);
        if (state1){
            System.out.println("增加成功");
        }
    };

    @Test
    public void update(){
        //        改
        Provider provider1 = new Provider(10025,"修改后的柳州供应商","广西柳州","刘先生","24207069800@qq.com","18778493825");

        boolean state2 = providerDao.update(provider1);
        if (state2){
            System.out.println("修改成功");
        }
    };

    @Test
    public void delete(){
        //        删

        Provider provider1 = new Provider(10025,"修改后的柳州供应商","广西柳州","刘先生","24207069800@qq.com","18778493825");
        boolean state3 = providerDao.delete(provider1);
        if (state3){
            System.out.println("删除成功");
        }
    };

}

