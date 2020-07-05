package dao;

import pojo.Pager;
import pojo.StockOut;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface StockOutDao extends BaseDao<StockOut> {
    @Override
    boolean add(StockOut object);

    @Override
    boolean update(StockOut object);

    @Override
    boolean delete(StockOut object);

    @Override
    List<StockOut> findByPager(Pager<StockOut> pager);

    @Override
    Integer findTotalByPager(Pager<StockOut> pager);
}
