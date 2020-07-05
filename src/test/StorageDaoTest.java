import dao.GoodsDao;
import dao.StorageDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Pager;
import pojo.Storage;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class StorageDaoTest {

    private StorageDao storageDao;

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
        storageDao = sqlSession.getMapper(StorageDao.class);
    }

    @Test
    public void findByPager(){
        //          查
        Pager<Storage> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<Storage> list =storageDao.findByPager(pager);
        for (Storage storage: list) {
            System.out.println("仓库名字："+storage.getStorageName());
        }
        //        统计功能
        int count =  storageDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
    }

    @Test
    public void add(){
        //        增
        LocalDateTime localDateTime = LocalDateTime.now();
        Storage storage = new Storage(10019,"十二号仓库","广西",10000,5000,9000);
        boolean state1 = storageDao.add(storage);
        if (state1){
            System.out.println("增加成功");
        }
    };

    @Test
    public void update(){
        //        改
        Storage storage1 = new Storage(10015,"专属仓库","广西",10000,5000,9000);

        boolean state2 =storageDao.update(storage1);
        if (state2){
            System.out.println("修改成功");
        }
    };

    @Test
    public void delete(){
        //        删
        Storage storage = new Storage(10019,"十二号仓库","广西",10000,5000,9000);
        boolean state3 = storageDao.delete(storage);
        if (state3){
            System.out.println("删除成功");
        }
    };
}
