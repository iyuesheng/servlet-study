package org.dullnull.service;

import org.dullnull.dao.UserDao;
import org.dullnull.domain.User;

/**
 * @author iisheng
 * @date 2018/03/21 13:19:11
 */
public class UserService {

    public User getById(String id) {
        return new UserDao().getById(id);
    }
}
