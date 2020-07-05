package dao;

import pojo.Client;
import pojo.Pager;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface ClientDao extends BaseDao<Client> {
    @Override
    boolean add(Client object);

    @Override
    boolean update(Client object);

    @Override
    boolean delete(Client object);

    @Override
    List<Client> findByPager(Pager<Client> pager);

    @Override
    Integer findTotalByPager(Pager<Client> pager);
}
