package dao;

import pojo.Pager;
import pojo.Purchasing;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface PurchasingDao extends BaseDao<Purchasing> {
    @Override
    boolean add(Purchasing object);

    @Override
    boolean update(Purchasing object);

    @Override
    boolean delete(Purchasing object);

    @Override
    List<Purchasing> findByPager(Pager<Purchasing> pager);

    @Override
    Integer findTotalByPager(Pager<Purchasing> pager);
}
