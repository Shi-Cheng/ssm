package dx.cn.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import dx.cn.domain.Orders;
import dx.cn.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderControl {

    @Autowired
    private IOrderService orderService;

    private ModelAndView view = null;

//     @RequestMapping("/findOrdersAll.do")
//    public ModelAndView findOrdersAll(){
//        List<Orders> orders = orderService.findOrdersAll();
//        view = new ModelAndView();
//        view.addObject("orderList",orders);
//        view.setViewName("order-list");
//        return view;
//    }
    @RequestMapping("/findOrdersAll.do")
    public ModelAndView findOrdersAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name ="size",required = true, defaultValue = "4") int size){
        List<Orders> orders = orderService.findOrdersAll(page, size);
        PageInfo pageInfo = new PageInfo(orders);
        view = new ModelAndView();
        view.addObject("orderList",pageInfo);
        view.setViewName("order-list");
        return view;
    }

    @RequestMapping("/findOrderById.do")
    public ModelAndView findOrderById(String order_id){
        System.out.println("================="+order_id+"===================");
        int id = Integer.parseInt(order_id);
        Orders order = orderService.findOrderById(id);
        view = new ModelAndView();
        view.addObject("orderDetail",order);
        view.setViewName("order-page-show");
        return view;
    }
}
