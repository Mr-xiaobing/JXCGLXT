package dao;

import pojo.Pager;
import pojo.SalesReturn;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface SalesReturnDao extends  BaseDao<SalesReturn> {
    @Override
    boolean add(SalesReturn object);

    @Override
    boolean update(SalesReturn object);

    @Override
    boolean delete(SalesReturn object);

    @Override
    List<SalesReturn> findByPager(Pager<SalesReturn> pager);

    @Override
    Integer findTotalByPager(Pager<SalesReturn> pager);
}
