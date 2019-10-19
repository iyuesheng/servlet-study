package cn.iisheng.service;

import cn.iisheng.dao.UserDao;
import cn.iisheng.domain.UserDO;

/**
 * @author iisheng
 * @date 2018/03/21 13:19:11
 */
public class UserService {

    public UserDO getById(String id) {
        return new UserDao().getById(id);
    }
}
