package dx.cn.controller;

import dx.cn.domain.Product;
import dx.cn.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll.do")
    public String findAll() throws Exception{
        System.out.println("====controller====");
        List<Product> products = productService.findAll();
        for (Product product : products){
            System.out.println(product);
        }
        return "product-list";
    }
}
