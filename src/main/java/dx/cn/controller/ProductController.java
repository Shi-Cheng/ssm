package dx.cn.controller;
import dx.cn.domain.Product;
import dx.cn.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * 显示所有的订单详情
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        List<Product> products = productService.findAll();
        ModelAndView view = new ModelAndView();
        view.addObject("productList",products);
        view.setViewName("product-list");
        return view;
    }

    //产品添加
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        System.out.println("========================"+product.getCityName()+"=================");
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/delete.do")
    public String delete(@RequestParam(value="pid[]") String[] products_id) throws Exception{
        for (String product_id : products_id){
            Integer id = Integer.parseInt(product_id);
            productService.deleteProductById(id);
        }
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String product_id){
        System.out.println("========================"+product_id+"=================");
        Integer id = Integer.parseInt(product_id);
        Product product = productService.findById(id);
        ModelAndView view = new ModelAndView();
        view.addObject("product_detail",product);
        view.setViewName("product-page-show");
        return view;
    }
}
