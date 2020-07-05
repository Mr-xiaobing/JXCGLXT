import dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.*;
import tool.MybatisTool;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
    private  GoodsDao goodsDao;
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
        System.out.println("总数量："+count);
//        插入功能

        Goods goods1 = new Goods(1,"手机",10001,10001,"9.5寸","<p>6.18特惠</P>","C:/Users/xiaobing/Desktop/img/Banana.jpg");
        boolean state1 =false;
         state1= goodsDao.add(goods1);
        if (state1)
        {
            System.out.println("添加成功");
        }
//       修改功能
        Goods goods2 = new Goods(10018,"修改后的手机",10001,10001,"9.5寸","<p>6.18特惠</P>","C:/Users/xiaobing/Desktop/img/Banana.jpg");
        boolean state2 = goodsDao.update(goods2);
        if (state2)
        {
            System.out.println("修改成功");
        }
//        删除功能
        boolean state3 = goodsDao.delete(goods2);
        if (state3){
            System.out.println("删除成功");
        }
        System.out.println("<===============================>");
        System.out.println();
    }

//    测试 clientNoDao接口
    @Test
    public void  testClientDao(){
        System.out.println("<===========Client测试================>");
        //        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


//        实例化
        ClientDao clientDao =  sqlSession.getMapper(dao.ClientDao.class);

//        查增改删
//          查
        Pager<Client> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<Client> list = clientDao.findByPager(pager);

        for (Client client: list) {
            System.out.println("客户名："+client.getClient());
        }
//        增
        Client client1 = new Client(1,"刘先生","柳州","2420709800@qq.com","18778485555");
        boolean state1 = clientDao.add(client1);
        if (state1){
            System.out.println("添加成功");
        }
//        统计功能
        int count =  clientDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
//        改
        Client client2 = new Client(10013,"修改后的刘先生","柳州","2420709800@qq.com","18778485555");
        boolean state2 = clientDao.update(client2);
        if (state2){
            System.out.println("修改成功");
        }
//        删除
        Client client3 = new Client(10014,"修改后的刘先生","柳州","2420709800@qq.com","18778485555");
        boolean state3 = clientDao.delete(client3);
        if (state2){
            System.out.println("删除成功");
        }
        System.out.println("<===============================>");
    }

    @Test
//    测试 goodsTypeDao接口
    public void testGoodsType(){
        System.out.println("<===========GoodsType测试================>");
        //        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


//        实例化
        GoodsTypeDao goodsTypeDao=  sqlSession.getMapper(GoodsTypeDao.class);

//        查增改删
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
//        增
        LocalDateTime localDateTime = LocalDateTime.now();
        GoodsType goodsType1 = new GoodsType(10016,"黑科技",localDateTime);
        boolean state1 =  goodsTypeDao.add(goodsType1);
        if (state1){
            System.out.println("增加成功");
        }
//        改
        GoodsType goodsType2 = new GoodsType(10014,"修改后的黑科技",localDateTime);
        boolean state2 =  goodsTypeDao.update(goodsType2);
        if (state2){
            System.out.println("修改成功");
        }
//        删
        boolean state3 = goodsTypeDao.delete(goodsType1);
        if (state3){
            System.out.println("删除成功");
        }

        System.out.println("<===============================>");
    }


    @Test
//    测试providerDao接口
    public void testProvider(){
        System.out.println("<===========Provider测试================>");
        //        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        实例化
        ProviderDao providerDao  = sqlSession.getMapper(ProviderDao.class);

//        查增改删
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
//        增

        Provider provider = new Provider(10025,"柳州供应商","广西柳州","刘先生","24207069800@qq.com","18778493825");
        boolean state1 = providerDao.add(provider);
        if (state1){
            System.out.println("增加成功");
        }
//        改
        Provider provider1 = new Provider(10025,"修改后的柳州供应商","广西柳州","刘先生","24207069800@qq.com","18778493825");

        boolean state2 = providerDao.update(provider1);
        if (state2){
            System.out.println("修改成功");
        }
//        删
        boolean state3 = providerDao.delete(provider1);
        if (state3){
            System.out.println("删除成功");
        }

        System.out.println("<===============================>");
    }

    @Test
//    测试purchasing接口
    public void testPurchasing(){
        System.out.println("<===========Purchasing测试================>");
        //        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        实例化
        PurchasingDao purchasingDao = sqlSession.getMapper(PurchasingDao.class);

//        查增改删
//          查
        Pager<Purchasing> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<Purchasing> list =purchasingDao.findByPager(pager);

        for (Purchasing purchasing: list) {
            System.out.println("采购订单号："+purchasing.getpNo());
        }
        //        统计功能
        int count =  purchasingDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
//        增

        LocalDateTime localDateTime = LocalDateTime.now();
        Purchasing purchasing = new Purchasing(10022,10008,200,20.5,localDateTime,"管理员","刘先生的订单",10011);
        boolean state1 =purchasingDao.add(purchasing);
        if (state1){
            System.out.println("增加成功");
        }
//        改
        Purchasing purchasing1 = new Purchasing(10021,10008,200,20.5,localDateTime,"管理员","修改后刘先生的订单",10011);

        boolean state2 = purchasingDao.update(purchasing1);
        if (state2){
            System.out.println("修改成功");
        }
//        删
        boolean state3 = purchasingDao.delete(purchasing1);
        if (state3){
            System.out.println("删除成功");
        }

        System.out.println("<===============================>");
    }

//    测试Purchasing_return接口
    @Test
    public void testPurchasing_return(){
        System.out.println("<===========PurchasingReturn测试================>");
        //        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        实例化
        PurchasingReturnDao purchasingReturnDao =sqlSession.getMapper(PurchasingReturnDao.class);

//        查增改删
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
//        增

        LocalDateTime localDateTime = LocalDateTime.now();
        PurchasingReturn purchasingReturn = new PurchasingReturn(10003,10008,200,20.5,localDateTime,"管理员","王先生的订单",10011);
        boolean state1 =purchasingReturnDao.add(purchasingReturn);
        if (state1){
            System.out.println("增加成功");
        }
//        改
        PurchasingReturn purchasingReturn1 = new PurchasingReturn(10003,10008,200,20.5,localDateTime,"管理员","王先生的订单",10011);

        boolean state2 = purchasingReturnDao.update(purchasingReturn1);
        if (state2){
            System.out.println("修改成功");
        }
//        删
        boolean state3 = purchasingReturnDao.delete(purchasingReturn1);
        if (state3){
            System.out.println("删除成功");
        }

        System.out.println("<===============================>");
    }

//    测试 sales接口
    @Test
    public void testSales(){
        System.out.println("<===========Sales测试================>");
        //        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        实例化
        SalesDao salesDao = sqlSession.getMapper(SalesDao.class);

//        查增改删
//          查
        Pager<Sales> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<Sales> list =salesDao.findByPager(pager);

        for (Sales sales: list) {
            System.out.println("出售的订单号："+sales.getsNo());
        }
        //        统计功能
        int count =  salesDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
//        增
        LocalDateTime localDateTime = LocalDateTime.now();
        Sales sales = new Sales(10024,10002,800,45,localDateTime,"管理员",10007,"一笔大单",10011);
        boolean state1 =salesDao.add(sales);
        if (state1){
            System.out.println("增加成功");
        }
//        改
        Sales sales1 = new Sales(10024,10002,800,45,localDateTime,"管理员",10007,"一笔大单",10011);
        boolean state2 =salesDao.update(sales1);
        if (state2){
            System.out.println("修改成功");
        }
//        删
        boolean state3 = salesDao.delete(sales1);
        if (state3){
            System.out.println("删除成功");
        }

        System.out.println("<===============================>");
    }

//    测试sales_retrun接口
   @Test
    public void testSalesReturn(){
    System.out.println("<===========SalesReturn测试================>");
    //        运行配置环境
    String resource = "config/mybatis-config.xml";
    InputStream inputStream = null;
    try {
        inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
        e.printStackTrace();
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

//        实例化
    SalesReturnDao salesReturnDao = sqlSession.getMapper(SalesReturnDao.class);

//        查增改删
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
//        增
    LocalDateTime localDateTime = LocalDateTime.now();
    SalesReturn salesReturn = new SalesReturn(10018,10002,800,45,localDateTime,"管理员",10007,"一笔大单",10011);
    boolean state1 =salesReturnDao.add(salesReturn);
    if (state1){
        System.out.println("增加成功");
    }
//        改
       SalesReturn salesReturn1 = new SalesReturn(10010,10002,800,45,localDateTime,"管理员",10007,"修改后的一笔大单",10011);

    boolean state2 =salesReturnDao.update(salesReturn1);
    if (state2){
        System.out.println("修改成功");
    }
//        删
    boolean state3 = salesReturnDao.delete(salesReturn1);
    if (state3){
        System.out.println("删除成功");
    }

    System.out.println("<===============================>");
}


    //    测试stockIn接口
    @Test
    public void testStockIn(){
        System.out.println("<===========StockIn测试================>");
        //        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        实例化
        StockInDao stockInDao = sqlSession.getMapper(StockInDao.class);

//        查增改删
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
//        增
        LocalDateTime localDateTime = LocalDateTime.now();
        StockIn stockIn = new StockIn(10037,10001,10015,200,localDateTime,"管理员","一笔大单");
        boolean state1 =stockInDao.add(stockIn);
        if (state1){
            System.out.println("增加成功");
        }
//        改
        StockIn stockIn1 = new StockIn(10034,10001,10015,200,localDateTime,"管理员","一笔大单");
        boolean state2 =stockInDao.update(stockIn1);
        if (state2){
            System.out.println("修改成功");
        }
//        删
        boolean state3 = stockInDao.delete(stockIn1);
        if (state3){
            System.out.println("删除成功");
        }

        System.out.println("<===============================>");
    }


    //    测试StockOut接口
    @Test
    public void testStockOut(){
        System.out.println("<===========SalesReturn测试================>");
        //        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        实例化
        StockOutDao stockOutDao = sqlSession.getMapper(StockOutDao.class);

//        查增改删
//          查
        Pager<StockOut> pager = new Pager<>();
//        展示第一页
        pager.setPage(1);
//        展示五条数据
        pager.setSize(5);

        List<StockOut> list =stockOutDao.findByPager(pager);
        for (StockOut stockOut: list) {
            System.out.println("出货单号："+stockOut.getStockOutNo());
        }
        //        统计功能
        int count =  stockOutDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
//        增
        LocalDateTime localDateTime = LocalDateTime.now();
        StockOut stockOut = new StockOut(10037,10001,10015,200,localDateTime,"管理员","一笔大单");
        boolean state1 =stockOutDao.add(stockOut);
        if (state1){
            System.out.println("增加成功");
        }
//        改
        StockOut  stockOut1 = new StockOut(10020,10001,10015,200,localDateTime,"管理员","修改后的一笔大单");
        boolean state2 = stockOutDao.update(stockOut1);
        if (state2){
            System.out.println("修改成功");
        }
//        删
        boolean state3 = stockOutDao.delete(stockOut1);
        if (state3){
            System.out.println("删除成功");
        }

        System.out.println("<===============================>");
    }


    //    测试Storage接口
    @Test
    public void testStorage(){
        System.out.println("<===========Storage测试================>");
        //        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        实例化
        StorageDao storageDao = sqlSession.getMapper(StorageDao.class);

//        查增改删
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
//        增
        LocalDateTime localDateTime = LocalDateTime.now();
        Storage storage = new Storage(10019,"十二号仓库","广西",10000,5000,9000);
        boolean state1 = storageDao.add(storage);
        if (state1){
            System.out.println("增加成功");
        }
//        改
        Storage storage1 = new Storage(10015,"专属仓库","广西",10000,5000,9000);

        boolean state2 =storageDao.update(storage1);
        if (state2){
            System.out.println("修改成功");
        }
//        删
        boolean state3 = storageDao.delete(storage);
        if (state3){
            System.out.println("删除成功");
        }

        System.out.println("<===============================>");
    }


    //    测试UserMessage接口
    @Test
    public void testUserMessage(){
        System.out.println("<===========UserMessage测试================>");
        //        运行配置环境
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        实例化
        UserMessageDao userMessageDao = sqlSession.getMapper(UserMessageDao.class);

//        查增改删
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
        //        统计功能
        int count =  userMessageDao.findTotalByPager(pager);
        System.out.println("总数量："+count);
//        增
        LocalDateTime localDateTime = LocalDateTime.now();
        UserMessage userMessage = new UserMessage(10016,"xiaobin",null,"123456","18778493825","2420709800@qq.com",localDateTime);
        boolean state1 =userMessageDao.add(userMessage);
        if (state1){
            System.out.println("增加成功");
        }
//        改
        UserMessage userMessage1 = new UserMessage(10014,"real_xiaobin",null,"123456","18778493825","2420709800@qq.com",localDateTime);

        boolean state2 =userMessageDao.update(userMessage1);
        if (state2){
            System.out.println("修改成功");
        }
//        删
        boolean state3 = userMessageDao.delete(userMessage1);
        if (state3){
            System.out.println("删除成功");
        }

        System.out.println("<===============================>");
    }

    @After
    public  void  close(){
       sqlSession.close();
    }
}
