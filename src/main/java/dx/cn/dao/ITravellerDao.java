package dx.cn.dao;

import dx.cn.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    // 订单与游客的关系是多对多，查询某个游客买了产品id，根据订单id查询游客id，再得到相应游客信息
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{id})")
    List<Traveller> findByOrderId(int id) throws Exception;
}
