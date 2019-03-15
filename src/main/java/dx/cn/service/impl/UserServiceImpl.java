package dx.cn.service.impl;
import com.github.pagehelper.PageHelper;
import dx.cn.dao.IUserDao;
import dx.cn.domain.UserInfo;
import dx.cn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public UserInfo findByUsername(String username) throws Exception {
        return userDao.findByUsername(username);
    }

    @Override
    public List<UserInfo> findAll(int size,int page) {
        PageHelper.startPage(size,page);
        return userDao.findAll();
    }

    @Override
    public UserInfo findByUserId(int id) {
        return userDao.findByUserId(id);
    }

    @Override
    public void saveUser(UserInfo userInfo) {
        userDao.saveUser(userInfo);
    }


}

