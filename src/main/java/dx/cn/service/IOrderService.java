package dx.cn.service;

import dx.cn.domain.Orders;

import java.util.List;

public interface IOrderService {

    List<Orders> findOrdersAll(int page,int size);

    Orders findOrderById(int id);
}
