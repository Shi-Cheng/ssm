package dx.cn.dao;
import dx.cn.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("select * from users where username=#{username}")
    UserInfo findByUsername(String username) throws Exception ;

    @Select("select * from users")
    List<UserInfo> findAll();

    @Select("select * from users where id =#{id}")
    UserInfo findByUserId(int id);

    @Insert("insert into users(username,PASSWORD,email,phonenum,status) values(#{username},#{password},#{email},#{phoneNum},#{status})")
    void saveUser(UserInfo userInfo);

}
