package dx.cn.service.impl;

import com.github.pagehelper.PageHelper;
import dx.cn.dao.IOrderDao;
import dx.cn.domain.Orders;
import dx.cn.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Orders> findOrdersAll() {

        return orderDao.findOrdersAll();
    }

    @Override
    public Orders findOrderById(int id) {
        return orderDao.findOrderById(id);
    }
}
