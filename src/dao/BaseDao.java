package dao;

import pojo.Pager;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 * @param <T>
 */
public interface BaseDao<T> {

    /**
     * 通用新增方法
     * @param object
     * @return
     */

    boolean add (T object);

    /**
     * 通用修改方法
     * @param object
     * @return
     */

    boolean update(T object);

    /**
     * 通用删除方法
     * @param object
     * @return
     */

    boolean delete(T object);

    /**
     * 带条件查询的分页类
     * @param pager
     * @return
     */

    List<T> findByPager(Pager<T> pager);

    /**
     * 统计查询条件下的记录总数
     * @param pager
     * @return
     */

    Integer findTotalByPager(Pager<T> pager);


}
