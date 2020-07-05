package dao;

import pojo.GoodsType;
import pojo.Pager;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface GoodsTypeDao extends BaseDao<GoodsType>{
    @Override
    boolean add(GoodsType object);

    @Override
    boolean update(GoodsType object);

    @Override
    boolean delete(GoodsType object);

    @Override
    List<GoodsType> findByPager(Pager<GoodsType> pager);

    @Override
    Integer findTotalByPager(Pager<GoodsType> pager);
}
