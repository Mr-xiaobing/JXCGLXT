package tool;

import dao.GoodsDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author XBin
 * @param
 */
public class MybatisTool {

    public SqlSession  initMybatis(){

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
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        通过反射进行 实例化
        return  sqlSession;
    }
}
