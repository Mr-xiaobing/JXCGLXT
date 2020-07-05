package dao;

import pojo.Pager;
import pojo.Storage;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface StorageDao extends BaseDao<Storage> {
    @Override
    boolean add(Storage object);

    @Override
    boolean update(Storage object);

    @Override
    boolean delete(Storage object);

    @Override
    List<Storage> findByPager(Pager<Storage> pager);

    @Override
    Integer findTotalByPager(Pager<Storage> pager);
}
