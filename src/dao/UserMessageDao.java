package dao;

import pojo.Pager;
import pojo.UserMessage;

import java.util.List;

/**
 * @author XBin
 * @date  2020/7/3
 */

public interface UserMessageDao extends BaseDao<UserMessage> {
    @Override
    boolean add(UserMessage object);

    @Override
    boolean update(UserMessage object);

    @Override
    boolean delete(UserMessage object);

    @Override
    List<UserMessage> findByPager(Pager<UserMessage> pager);

    @Override
    Integer findTotalByPager(Pager<UserMessage> pager);
}
