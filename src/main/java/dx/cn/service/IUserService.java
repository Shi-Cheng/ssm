package dx.cn.service;


import dx.cn.domain.UserInfo;

import java.util.List;

public interface IUserService{

    UserInfo findByUsername(String username) throws Exception ;

    List<UserInfo> findAll(int page,int size);

    UserInfo findByUserId(int id);

    void saveUser(UserInfo userInfo);
}