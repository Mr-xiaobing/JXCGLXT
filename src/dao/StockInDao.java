package dao;

import pojo.Pager;
import pojo.StockIn;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface StockInDao extends BaseDao<StockIn> {
    @Override
    boolean add(StockIn object);

    @Override
    boolean update(StockIn object);

    @Override
    boolean delete(StockIn object);

    @Override
    List<StockIn> findByPager(Pager<StockIn> pager);

    @Override
    Integer findTotalByPager(Pager<StockIn> pager);
}
