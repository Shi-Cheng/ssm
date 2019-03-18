package dx.cn.dao;

import dx.cn.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class, many = @Many(select = "dx.cn.dao.IRoleDao.findRoleByUserId")),
    })
    UserInfo findByUsername(String username) throws Exception ;

    @Select("select * from users")
    List<UserInfo> findAll();

    @Select("select * from users where id =#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class, many = @Many(select = "dx.cn.dao.IRoleDao.findRoleByUserId")),
    })
    UserInfo findByUserId(int id);

    @Insert("insert into users(username,PASSWORD,email,phonenum,status) values(#{username},#{password},#{email},#{phoneNum},#{status})")
    void saveUser(UserInfo userInfo);

}
