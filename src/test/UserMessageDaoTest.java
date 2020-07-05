import dao.ClientDao;
import dao.UserMessageDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.Pager;
import pojo.UserMessage;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class UserMessageDaoTest {
    private UserMessageDao userMessageDao;
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
        userMessageDao = sqlSession.getMapper(UserMessageDao.class);
    }


    @Test
    public void findByPager(){
        //          查
        Pager<UserMessage> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<UserMessage> list = userMessageDao.findByPager(pager);
        for (UserMessage userMessage: list) {
            System.out.println("用户名字："+userMessage.getUserName());

        }
        Pager<UserMessage> pager1 = new Pager<>();
        UserMessage userMessage = new UserMessage(10001,"天",null,null,"18778493825",null,null);
        pager1.setCondition(userMessage);
        List<UserMessage> list1 = userMessageDao.findByPager(pager1);
        System.out.println("-------查询用户名字带有天-------");
        for (UserMessage userMessage5: list1) {
            System.out.println("用户名字："+userMessage5.getUserName());
        }
        //        统计功能
        int count =  userMessageDao.findTotalByPager(pager1);
        System.out.println("总数量："+count);
    }

    @Test
    public void add(){
//        增
        LocalDateTime localDateTime = LocalDateTime.now();
        UserMessage userMessage = new UserMessage(10016,"xiaobin",null,"123456","18778493825","2420709800@qq.com",localDateTime);
        boolean state1 =userMessageDao.add(userMessage);
        if (state1){
            System.out.println("增加成功");
        }
    }

    @Test
    public void update(){
        //        改
        LocalDateTime localDateTime = LocalDateTime.now();
        UserMessage userMessage1 = new UserMessage(10014,"real_xiaobin",null,"123456","18778493825","2420709800@qq.com",localDateTime);

        boolean state2 =userMessageDao.update(userMessage1);
        if (state2){
            System.out.println("修改成功");
        }
    }

    @Test
    public void delete() {
        //        删
        LocalDateTime localDateTime = LocalDateTime.now();
        UserMessage userMessage1 = new UserMessage(10014,"real_xiaobin",null,"123456","18778493825","2420709800@qq.com",localDateTime);
        boolean state3 = userMessageDao.delete(userMessage1);
        if (state3){
            System.out.println("删除成功");
        }
    }
}
