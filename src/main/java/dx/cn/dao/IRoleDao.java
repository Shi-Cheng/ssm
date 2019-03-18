package dx.cn.dao;

import dx.cn.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    @Select("select * from role where id in (select roleId from users_role where userid=#{userid})")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc" ,column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "dx.cn.dao.IPermissionDao.findByRoleId"))

    })
    List<Role> findRoleByUserId(int userid) throws Exception;

}
