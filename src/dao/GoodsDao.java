package dao;

import pojo.Goods;
import pojo.Pager;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface GoodsDao extends BaseDao<Goods> {
    /**
     *
     * @param object 新增参数
     * @return 无异常
     */
    @Override
    boolean add(Goods object);

    /**
     *
     * @param object
     * @return
     */
    @Override
    boolean update(Goods object);

    /**
     *
     * @param object
     * @return
     */
    @Override
    boolean delete(Goods object);

    /**
     *
     * @param pager
     * @return
     */
    @Override
    List<Goods> findByPager(Pager<Goods> pager);

    /**
     *
     * @param pager
     * @return
     */

    @Override
    Integer findTotalByPager(Pager<Goods> pager);
}
