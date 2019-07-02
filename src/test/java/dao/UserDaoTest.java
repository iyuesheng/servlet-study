package dao;

import org.dullnull.dao.UserDao;
import org.dullnull.domain.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author iSheng
 * @date 2018/03/21 12:43:28
 */
public class UserDaoTest {

    private UserDao userDao =new UserDao();

    @Test
    public void getByIdTest() {
        String id = "isheng.me";
        User user = userDao.getById(id);
        Assert.assertNotNull(user);
        System.out.println(user);
    }
}
