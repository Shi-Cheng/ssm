package dx.cn.dao;

import dx.cn.domain.Member;
import dx.cn.domain.Orders;
import dx.cn.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDao {

    /**
     * 查询所有的订单操作
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "dx.cn.dao.IProductDao.findById")),
    })
    List<Orders> findOrdersAll();

    /**
     * 根据id查询订单,关联product，member和traveller
     * @param id
     * @return
     */
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "dx.cn.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "dx.cn.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "memberId",javaType = java.util.List.class,many = @Many(select = "dx.cn.dao.ITravellerDao.findByOrderId")),
    })
    Orders findOrderById(int id);
}
