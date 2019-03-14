package dx.cn.dao;

import dx.cn.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    Member findById(int id) throws Exception;
}
