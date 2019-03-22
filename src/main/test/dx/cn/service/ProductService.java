package dx.cn.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    private Long phone;

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Autowired IProductService productService;
    @Test
    public void findProductAll(){
        String name = "user";
        String name1 ="user";
        System.out.println(name.equals(name1));
    }


    public void testResult(){


    }
}
