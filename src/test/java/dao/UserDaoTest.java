package dao;

import org.dullnull.dao.UserDao;
import org.dullnull.domain.UserDO;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author iisheng
 * @date 2018/03/21 12:43:28
 */
public class UserDaoTest {

    private UserDao userDao =new UserDao();

    @Test
    public void getByIdTest() {
        String id = "1";
        UserDO userDO = userDao.getById(id);
        Assert.assertNotNull(userDO);
        System.out.println(userDO);
    }
}
