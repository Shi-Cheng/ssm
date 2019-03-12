package dx.cn.dao;

import dx.cn.domain.Orders;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDao {

    /**
     * 查询所有的订单操作
     * @return
     */
    @Select("select * from orders")
    List<Orders> findOrdersAll();

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @Select("select * from orders where id=#{id}")
    Orders findOrderById(int id);
}
