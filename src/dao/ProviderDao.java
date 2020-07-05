package dao;

import pojo.Pager;
import pojo.Provider;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface ProviderDao extends BaseDao<Provider>{
    @Override
    boolean add(Provider object);

    @Override
    boolean update(Provider object);

    @Override
    boolean delete(Provider object);

    @Override
    List<Provider> findByPager(Pager<Provider> pager);

    @Override
    Integer findTotalByPager(Pager<Provider> pager);
}
