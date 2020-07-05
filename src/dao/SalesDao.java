package dao;

import pojo.Pager;
import pojo.Sales;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface SalesDao extends BaseDao<Sales>{
    @Override
    boolean add(Sales object);

    @Override
    boolean update(Sales object);

    @Override
    boolean delete(Sales object);

    @Override
    List<Sales> findByPager(Pager<Sales> pager);

    @Override
    Integer findTotalByPager(Pager<Sales> pager);
}
