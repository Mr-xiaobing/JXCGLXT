package dao;

import pojo.Pager;
import pojo.PurchasingReturn;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface PurchasingReturnDao extends BaseDao<PurchasingReturn> {
    @Override
    boolean add(PurchasingReturn object);

    @Override
    boolean update(PurchasingReturn object);

    @Override
    boolean delete(PurchasingReturn object);

    @Override
    List<PurchasingReturn> findByPager(Pager<PurchasingReturn> pager);

    @Override
    Integer findTotalByPager(Pager<PurchasingReturn> pager);
}
