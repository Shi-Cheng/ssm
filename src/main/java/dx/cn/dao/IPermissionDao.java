package dx.cn.dao;

import dx.cn.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

//    @Select("select * from role where id in (select roleId from users_role where userid=#{userid})")
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findByRoleId(int roleId);

}
