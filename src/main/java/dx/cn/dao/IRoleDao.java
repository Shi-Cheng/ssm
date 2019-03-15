package dx.cn.dao;

import dx.cn.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    @Select("select * from role where id in (select )")
    List<Role> findRoleByUserId(int userid) throws Exception;

}
